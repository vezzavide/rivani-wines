package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CatalogoController {

    CatalogoService catalogoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond catalogoService.list(params), model:[catalogoCount: catalogoService.count()]
    }

    def show(Long id) {
        respond catalogoService.get(id)
    }

    def create() {
        respond new Catalogo(params)
    }

    def save(Catalogo catalogo) {
        if (catalogo == null) {
            notFound()
            return
        }

        try {
            catalogoService.save(catalogo)
        } catch (ValidationException e) {
            respond catalogo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'catalogo.label', default: 'Catalogo'), catalogo.id])
                redirect catalogo
            }
            '*' { respond catalogo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond catalogoService.get(id)
    }

    def update(Catalogo catalogo) {
        if (catalogo == null) {
            notFound()
            return
        }

        try {
            catalogoService.save(catalogo)
        } catch (ValidationException e) {
            respond catalogo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'catalogo.label', default: 'Catalogo'), catalogo.id])
                redirect catalogo
            }
            '*'{ respond catalogo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        catalogoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'catalogo.label', default: 'Catalogo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def catalogo(){
        //TODO: popola catalogo con prodotti
        def listaProdotti = Prodotto.findAllByInCatalogo(true)

        // Aggiunge il range di prezzo per ciascun prodotto così da poterlo visualizzare nella view
        def listaProdottiPrezzi = []

        listaProdotti.each{
            def prodotto = it
            // Ottiene massimo prezzo
            def maxAnnata = Annata.createCriteria().list{
                eq("prodotto", prodotto)
                maxResults(1)
                order("prezzo", "desc")
            }

            // Ottiene minimo prezzo
            def minAnnata = Annata.createCriteria().list{
                eq("prodotto", prodotto)
                maxResults(1)
                order("prezzo", "asc")
            }

            def prezzo

            // Costruisce il label per il prezzo del prodotto
            if(maxAnnata[0] == null){
                prezzo = "€ n.d."
            } else if(maxAnnata[0] == minAnnata[0]){
                prezzo = "€ " + maxAnnata[0].prezzo.toString()
            } else{
                prezzo = "€ " + minAnnata[0].prezzo.toString() + " - € " + maxAnnata[0].prezzo.toString()
            }

            def coppiaProdottoPrezzo = [prodotto, prezzo]

            listaProdottiPrezzi.add(coppiaProdottoPrezzo)
        }


        // Ritorna solo i prodotti da visualizzare nel catalogo con relativi prezzi (o range di prezzi)
        [listaProdottiPrezzi: listaProdottiPrezzi]
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'catalogo.label', default: 'Catalogo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
