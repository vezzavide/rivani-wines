package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CantinaController {

    CantinaService cantinaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cantinaService.list(params), model:[cantinaCount: cantinaService.count()]
    }

    def show(Long id) {
        respond cantinaService.get(id)
    }

    def create() {
        respond new Cantina(params)
    }

    def save(Cantina cantina) {
        if (cantina == null) {
            notFound()
            return
        }

        try {
            cantinaService.save(cantina)
        } catch (ValidationException e) {
            respond cantina.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cantina.label', default: 'Cantina'), cantina.id])
                redirect cantina
            }
            '*' { respond cantina, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond cantinaService.get(id)
    }

    def update(Cantina cantina) {
        if (cantina == null) {
            notFound()
            return
        }

        try {
            cantinaService.save(cantina)
        } catch (ValidationException e) {
            respond cantina.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cantina.label', default: 'Cantina'), cantina.id])
                redirect cantina
            }
            '*'{ respond cantina, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        cantinaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cantina.label', default: 'Cantina'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cantina.label', default: 'Cantina'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
