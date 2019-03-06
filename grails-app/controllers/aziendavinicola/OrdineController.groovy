package aziendavinicola

import grails.validation.ValidationException
import sun.font.TrueTypeFont

import static org.springframework.http.HttpStatus.*

class OrdineController {

    OrdineService ordineService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ordineService.list(params), model:[ordineCount: ordineService.count()]
    }

    def show(Long id) {
        respond ordineService.get(id)
    }

    def create() {
        respond new Ordine(params)
    }

    def save(Ordine ordine) {
        if (ordine == null) {
            notFound()
            return
        }

        try {
            ordineService.save(ordine)
        } catch (ValidationException e) {
            respond ordine.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ordine.label', default: 'Ordine'), ordine.id])
                redirect ordine
            }
            '*' { respond ordine, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ordineService.get(id)
    }

    def update(Ordine ordine) {
        if (ordine == null) {
            notFound()
            return
        }

        try {
            ordineService.save(ordine)
        } catch (ValidationException e) {
            respond ordine.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ordine.label', default: 'Ordine'), ordine.id])
                redirect ordine
            }
            '*'{ respond ordine, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ordineService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ordine.label', default: 'Ordine'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def evadi(Long id){
        //TODO: evadere ordine
        def ordine = Ordine.get(id)
        ordine.evaso = true
        try {
            ordineService.save(ordine)
        } catch (ValidationException e) {
            respond ordine.errors, view:'edit'
            return
        }

    }

    // Popola la pagina del carrello
    def carrello(){
        if(session.utente == null || session.role != 'cliente'){
            redirect controller: 'utente', action: 'login'
            return
        }

        //flash.message = "prova"
        //TODO: servi elenco prodotti carrello
        def carrello = Ordine.findByAttualeCarrelloAndCliente(true, session.utente)
        if(carrello == null){
            redirect controller: 'catalogo', action: 'catalogo'
            flash.message = "Il carrello è attualmente vuoto."
            return
        }
        def lineeOrdine = carrello.lineeOrdine

        [carrello: carrello, lineeOrdine: lineeOrdine]
    }

    // salva l'ordine e lo rende disponibile ai dipendenti per poterlo evadere
    def checkout(){
        def carrello = Ordine.findByAttualeCarrelloAndCliente(true, session.utente)
        carrello.attualeCarrello = false
        carrello.save(flush: true)
        flash.message = "Ordine confermato!"
        redirect controller: 'catalogo', action: 'catalogo'
        return
    }

    //TODO: IMPORTANTE! rendere transactional questo metodo
    def annullaCarrello(){
        def carrello = Ordine.findByAttualeCarrelloAndCliente(true, session.utente)
        def lineeOrdine = carrello.lineeOrdine
        carrello.delete(flush: true)
        lineeOrdine.each{
            def annata = it.annata
            annata.giacenza += it.quantita
            annata.save(flush: true)
        }
        flash.message = "Ordine annullato."
        redirect controller: 'catalogo', action: 'catalogo'
        return
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ordine.label', default: 'Ordine'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
