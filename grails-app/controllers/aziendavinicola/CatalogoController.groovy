package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CatalogoController {

    CatalogoService catalogoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond catalogoService.list(params), model:[catalogoCount: catalogoService.count()]
    }

    def show(Long id) {
        respond catalogoService.get(id)
    }

    def create() {
        respond new Catalogo(params)
    }

    def save(Catalogo catalogo) {
        if (catalogo == null) {
            notFound()
            return
        }

        try {
            catalogoService.save(catalogo)
        } catch (ValidationException e) {
            respond catalogo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'catalogo.label', default: 'Catalogo'), catalogo.id])
                redirect catalogo
            }
            '*' { respond catalogo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond catalogoService.get(id)
    }

    def update(Catalogo catalogo) {
        if (catalogo == null) {
            notFound()
            return
        }

        try {
            catalogoService.save(catalogo)
        } catch (ValidationException e) {
            respond catalogo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'catalogo.label', default: 'Catalogo'), catalogo.id])
                redirect catalogo
            }
            '*'{ respond catalogo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        catalogoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'catalogo.label', default: 'Catalogo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'catalogo.label', default: 'Catalogo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
