package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VitignoController {

    VitignoService vitignoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vitignoService.list(params), model:[vitignoCount: vitignoService.count()]
    }

    def show(Long id) {
        respond vitignoService.get(id)
    }

    def create() {
        respond new Vitigno(params)
    }

    def save(Vitigno vitigno) {
        if (vitigno == null) {
            notFound()
            return
        }

        try {
            vitignoService.save(vitigno)
        } catch (ValidationException e) {
            respond vitigno.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vitigno.label', default: 'Vitigno'), vitigno.id])
                redirect vitigno
            }
            '*' { respond vitigno, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vitignoService.get(id)
    }

    def update(Vitigno vitigno) {
        if (vitigno == null) {
            notFound()
            return
        }

        try {
            vitignoService.save(vitigno)
        } catch (ValidationException e) {
            respond vitigno.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vitigno.label', default: 'Vitigno'), vitigno.id])
                redirect vitigno
            }
            '*'{ respond vitigno, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vitignoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vitigno.label', default: 'Vitigno'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vitigno.label', default: 'Vitigno'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
