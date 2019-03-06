package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DipendenteController {

    DipendenteService dipendenteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dipendenteService.list(params), model:[dipendenteCount: dipendenteService.count()]
    }

    def show(Long id) {
        respond dipendenteService.get(id)
    }

    def create() {
        respond new Dipendente(params)
    }

    def save(Dipendente dipendente) {
        if (dipendente == null) {
            notFound()
            return
        }

        try {
            dipendenteService.save(dipendente)
        } catch (ValidationException e) {
            respond dipendente.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dipendente.label', default: 'Dipendente'), dipendente.id])
                redirect dipendente
            }
            '*' { respond dipendente, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond dipendenteService.get(id)
    }

    def update(Dipendente dipendente) {
        if (dipendente == null) {
            notFound()
            return
        }

        try {
            dipendenteService.save(dipendente)
        } catch (ValidationException e) {
            respond dipendente.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dipendente.label', default: 'Dipendente'), dipendente.id])
                redirect dipendente
            }
            '*'{ respond dipendente, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dipendenteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dipendente.label', default: 'Dipendente'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def toolDipendente(){

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dipendente.label', default: 'Dipendente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
