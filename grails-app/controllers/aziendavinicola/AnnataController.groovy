package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AnnataController {

    AnnataService annataService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond annataService.list(params), model:[annataCount: annataService.count()]
    }

    def show(Long id) {
        respond annataService.get(id)
    }

    def create() {
        respond new Annata(params)
    }

    def save(Annata annata) {
        if (annata == null) {
            notFound()
            return
        }

        try {
            annataService.save(annata)
        } catch (ValidationException e) {
            respond annata.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'annata.label', default: 'Annata'), annata.id])
                redirect annata
            }
            '*' { respond annata, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond annataService.get(id)
    }

    def update(Annata annata) {
        if (annata == null) {
            notFound()
            return
        }

        try {
            annataService.save(annata)
        } catch (ValidationException e) {
            respond annata.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'annata.label', default: 'Annata'), annata.id])
                redirect annata
            }
            '*'{ respond annata, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        annataService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'annata.label', default: 'Annata'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'annata.label', default: 'Annata'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
