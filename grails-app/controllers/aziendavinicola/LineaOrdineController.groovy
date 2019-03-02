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
