package aziendavinicola

//TODO: smista i redirect a seconda dello stato dell'utente:
// non loggato, cliente loggato, dipendente loggato o amministratore loggato?
class UserCheckInterceptor {
    UserCheckInterceptor(){
        matchAll()
                .excludes(controller: "catalogo")
                .excludes(controller: "prodotto", action: "schedaProdotto")
                .excludes(controller: "ordine", action: "carrello")
                .excludes(controller: "utente", action:"login")
                .excludes(controller: "utente", action:"logout")
                .excludes(controller: "lineaOrdine", action:"aggiungiACarrello")
                .excludes(controller: "ordine", action:"checkout")
                .excludes(controller: "ordine", action:"annullaCarrello")
                .excludes(controller: "notifica", action:"save")
                .excludes(controller: "notifica", action:"delete")
                .excludes(controller: "utente", action: "autenticaUtente")
                .excludes(controller: "cliente", action: "signup")

    }

    boolean before(){
        if(session.utente == null || session.role == 'cliente'){
            println("cliente o utente non loggato fa richiesta web")
            redirect controller: 'catalogo', action: 'catalogo'
            return
        }
        true
    }

    boolean after(){
        true
    }

    void afterView(){
        // no-op
    }
/*    UserCheckInterceptor(){
        matchAll()
                .excludes(controller: 'utente', action: 'login')
                .excludes(controller: 'cliente', action: 'signup')
                .excludes(controller: 'cliente', action: 'save')
                .excludes(controller: 'utente', action: 'autenticaUtente')

    }

    boolean before() {
        if(!session.utente){
            println("utente no loggato!")
            redirect controller: 'utente', action: 'login'
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }*/
}
