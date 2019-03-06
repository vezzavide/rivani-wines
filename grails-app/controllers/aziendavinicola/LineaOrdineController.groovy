package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LineaOrdineController {

    LineaOrdineService lineaOrdineService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond lineaOrdineService.list(params), model:[lineaOrdineCount: lineaOrdineService.count()]
    }

    def show(Long id) {
        respond lineaOrdineService.get(id)
    }

    def create() {
        respond new LineaOrdine(params)
    }

    def save(LineaOrdine lineaOrdine) {
        if (lineaOrdine == null) {
            notFound()
            return
        }

        try {
            lineaOrdineService.save(lineaOrdine)
        } catch (ValidationException e) {
            respond lineaOrdine.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lineaOrdine.label', default: 'LineaOrdine'), lineaOrdine.id])
                redirect lineaOrdine
            }
            '*' { respond lineaOrdine, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond lineaOrdineService.get(id)
    }

    def update(LineaOrdine lineaOrdine) {
        if (lineaOrdine == null) {
            notFound()
            return
        }

        try {
            lineaOrdineService.save(lineaOrdine)
        } catch (ValidationException e) {
            respond lineaOrdine.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'lineaOrdine.label', default: 'LineaOrdine'), lineaOrdine.id])
                redirect lineaOrdine
            }
            '*'{ respond lineaOrdine, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        lineaOrdineService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'lineaOrdine.label', default: 'LineaOrdine'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    //TODO: gestire l'atomicità delle operazioni in questo metodo, possibilmente con un service
    def aggiungiACarrello(){
        def annata = Annata.get(params.annata)
        String quantitaString = params.quantita
        Integer quantita = quantitaString.toInteger()
        println("aggiungo al carrello " + quantita.toString() + " bottiglie di " + annata.toString())

        //prendo l'attuale carrello(un'istanza di ordine con attualeCarrello = true) dal database, se esiste,
        // altrimenti creo l'ordine
        def ordineCarrello = Ordine.findByAttualeCarrelloAndCliente(true, session.utente)
        if(ordineCarrello == null){
            ordineCarrello = new Ordine()
            ordineCarrello.data = new Date()
            ordineCarrello.cliente = session.utente
            ordineCarrello.evaso = false
            ordineCarrello.attualeCarrello = true
        }

        // Aggiungo linea ordine al carrello e decremento subito la giacenza dell'annata
        // come una sorta di meccanismo di prenotazione da parte del cliente
        //(TODO: questa chiaramente non è una soluzione ideale e in futuro necessita miglioramenti)
        def lineaOrdine = new LineaOrdine()
        annata.giacenza -= quantita
        lineaOrdine.annata = annata
        lineaOrdine.quantita = quantita
        ordineCarrello.addToLineeOrdine(lineaOrdine)
        ordineCarrello.save(flush: true)
        annata.save(flush: true)

        // Gestisco notifiche ai dipendenti
        // NB: gestirle in questo punto è sufficiente in quanto i dipendenti sono interessati a venire a conoscenza
        // di una giacenza nulla solo in caso questa sia cnseguenza di un ordine di un cliente. in tal caso,
        // l'operazione deve passare per forza da questo punto
        if(annata.giacenza == 0) {
            def notificationService = new NotificationService()
            def responsabiliMagazzino = Dipendente.findAllByResponsabileMagazzino(true)
            responsabiliMagazzino.each {
                String messaggio = "Scorte esaurite per " + annata.toString() + "!"
                notificationService.sendNotification(it, messaggio)
            }
        }
        flash.message = "Aggiunto al carrello!"
        redirect controller:'prodotto', action: 'schedaProdotto', id: annata.prodotto.id
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lineaOrdine.label', default: 'LineaOrdine'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
