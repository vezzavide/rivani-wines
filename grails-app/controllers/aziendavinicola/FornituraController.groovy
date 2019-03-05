package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FornituraController {

    FornituraService fornituraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fornituraService.list(params), model:[fornituraCount: fornituraService.count()]
    }

    def show(Long id) {
        respond fornituraService.get(id)
    }

    def create() {
        respond new Fornitura(params)
    }

    def save(Fornitura fornitura) {
        if (fornitura == null) {
            notFound()
            return
        }

        try {
            fornitura.dipendente = session.utente
            fornitura.annata.giacenza += fornitura.quantita
            fornituraService.save(fornitura)
            /*AnnataService annataService
            def annata = Annata.findByAnno(fornitura.annata.id)
            annata.giacenza -= params.quantita
            annataService.save(annata)*/

        } catch (ValidationException e) {
            respond fornitura.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fornitura.label', default: 'Fornitura'), fornitura.id])
                redirect fornitura
            }
            '*' { respond fornitura, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fornituraService.get(id)
    }

    def update(Fornitura fornitura) {
        if (fornitura == null) {
            notFound()
            return
        }

        try {
            fornituraService.save(fornitura)
        } catch (ValidationException e) {
            respond fornitura.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fornitura.label', default: 'Fornitura'), fornitura.id])
                redirect fornitura
            }
            '*'{ respond fornitura, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fornituraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fornitura.label', default: 'Fornitura'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fornitura.label', default: 'Fornitura'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
