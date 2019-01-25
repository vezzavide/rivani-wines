package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FornitoreController {

    FornitoreService fornitoreService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fornitoreService.list(params), model:[fornitoreCount: fornitoreService.count()]
    }

    def show(Long id) {
        respond fornitoreService.get(id)
    }

    def create() {
        respond new Fornitore(params)
    }

    def save(Fornitore fornitore) {
        if (fornitore == null) {
            notFound()
            return
        }

        try {
            fornitoreService.save(fornitore)
        } catch (ValidationException e) {
            respond fornitore.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fornitore.label', default: 'Fornitore'), fornitore.id])
                redirect fornitore
            }
            '*' { respond fornitore, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fornitoreService.get(id)
    }

    def update(Fornitore fornitore) {
        if (fornitore == null) {
            notFound()
            return
        }

        try {
            fornitoreService.save(fornitore)
        } catch (ValidationException e) {
            respond fornitore.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fornitore.label', default: 'Fornitore'), fornitore.id])
                redirect fornitore
            }
            '*'{ respond fornitore, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fornitoreService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fornitore.label', default: 'Fornitore'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fornitore.label', default: 'Fornitore'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
