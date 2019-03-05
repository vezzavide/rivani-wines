package aziendavinicola

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProdottoController {

    ProdottoService prodottoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond prodottoService.list(params), model:[prodottoCount: prodottoService.count()]
    }

    def show(Long id) {
        respond prodottoService.get(id)
    }

    def create() {
        respond new Prodotto(params)
    }

    def save(Prodotto prodotto) {
        if (prodotto == null) {
            notFound()
            return
        }

        try {
            prodottoService.save(prodotto)
        } catch (ValidationException e) {
            respond prodotto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'prodotto.label', default: 'Prodotto'), prodotto.id])
                redirect prodotto
            }
            '*' { respond prodotto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond prodottoService.get(id)
    }

    def update(Prodotto prodotto) {
        if (prodotto == null) {
            notFound()
            return
        }

        try {
            prodottoService.save(prodotto)
        } catch (ValidationException e) {
            respond prodotto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'prodotto.label', default: 'Prodotto'), prodotto.id])
                redirect prodotto
            }
            '*'{ respond prodotto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        prodottoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'prodotto.label', default: 'Prodotto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def schedaProdotto(Long id){
        def prodotto = Prodotto.get(id)
        def notificheAnno = []

        if (prodotto == null) {
            notFound()
            return
        }
/*        // Aggiunto per evitare LazyInitalizationException -  ma non lo capisco (da stackoverflow)
        if(!session.utente.isAttached()){
            session.utente.attach()
        }*/
        if(session.role == "cliente"){
            def cliente = Cliente.get(session.utente.id)
            def notifiche = cliente.notifiche

            println(notifiche)
            notifiche.each{
                notificheAnno.add(it.annata.anno)
            }
        }
        println(notificheAnno)
        [prodotto: prodotto, notificheAnno: notificheAnno]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'prodotto.label', default: 'Prodotto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
