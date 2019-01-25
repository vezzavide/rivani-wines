package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UtenteController {

    UtenteService utenteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond utenteService.list(params), model:[utenteCount: utenteService.count()]
    }

    def show(Long id) {
        respond utenteService.get(id)
    }

    def create() {
        respond new Utente(params)
    }

    def save(Utente utente) {
        if (utente == null) {
            notFound()
            return
        }

        try {
            utenteService.save(utente)
        } catch (ValidationException e) {
            respond utente.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'utente.label', default: 'Utente'), utente.id])
                redirect utente
            }
            '*' { respond utente, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond utenteService.get(id)
    }

    def update(Utente utente) {
        if (utente == null) {
            notFound()
            return
        }

        try {
            utenteService.save(utente)
        } catch (ValidationException e) {
            respond utente.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'utente.label', default: 'Utente'), utente.id])
                redirect utente
            }
            '*'{ respond utente, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        utenteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'utente.label', default: 'Utente'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'utente.label', default: 'Utente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
