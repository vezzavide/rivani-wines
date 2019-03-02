package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AmministratoreController {

    AmministratoreService amministratoreService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond amministratoreService.list(params), model:[amministratoreCount: amministratoreService.count()]
    }

    def show(Long id) {
        respond amministratoreService.get(id)
    }

    def create() {
        respond new Amministratore(params)
    }

    def save(Amministratore amministratore) {
        if (amministratore == null) {
            notFound()
            return
        }

        try {
            amministratoreService.save(amministratore)
        } catch (ValidationException e) {
            respond amministratore.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'amministratore.label', default: 'Amministratore'), amministratore.id])
                redirect amministratore
            }
            '*' { respond amministratore, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond amministratoreService.get(id)
    }

    def update(Amministratore amministratore) {
        if (amministratore == null) {
            notFound()
            return
        }

        try {
            amministratoreService.save(amministratore)
        } catch (ValidationException e) {
            respond amministratore.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'amministratore.label', default: 'Amministratore'), amministratore.id])
                redirect amministratore
            }
            '*'{ respond amministratore, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        amministratoreService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'amministratore.label', default: 'Amministratore'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'amministratore.label', default: 'Amministratore'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
