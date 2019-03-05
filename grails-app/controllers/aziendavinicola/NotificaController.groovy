package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class NotificaController {

    NotificaService notificaService

    static allowedMethods = [save: "POST", update: "PUT", delete: ["DELETE", "POST"]]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond notificaService.list(params), model:[notificaCount: notificaService.count()]
    }

    def show(Long id) {
        respond notificaService.get(id)
    }

    def create() {
        respond new Notifica(params)
    }

    def save(Notifica notifica) {
        if (notifica == null) {
            notFound()
            return
        }

        try {
            notificaService.save(notifica)
            if(session.role != null && session.role == 'cliente'){
                redirect controller: 'prodotto', action: 'schedaProdotto', id: notifica.annata.prodotto.id
                return
            }
        } catch (ValidationException e) {
            respond notifica.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'notifica.label', default: 'Notifica'), notifica.id])
                redirect notifica
            }
            '*' { respond notifica, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond notificaService.get(id)
    }

    def update(Notifica notifica) {
        if (notifica == null) {
            notFound()
            return
        }

        try {
            notificaService.save(notifica)
        } catch (ValidationException e) {
            respond notifica.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'notifica.label', default: 'Notifica'), notifica.id])
                redirect notifica
            }
            '*'{ respond notifica, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        def prodotto = notificaService.get(id).annata.prodotto
        notificaService.delete(id)

        if(session.role != null && session.role == 'cliente'){
            redirect controller: 'prodotto', action: 'schedaProdotto', id: prodotto.id
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'notifica.label', default: 'Notifica'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'notifica.label', default: 'Notifica'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
