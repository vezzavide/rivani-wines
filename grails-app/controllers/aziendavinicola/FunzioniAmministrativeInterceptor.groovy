package aziendavinicola

// Impedisco ad amministratori di accedere allo shop
class FunzioniAmministrativeInterceptor {
    FunzioniAmministrativeInterceptor(){
        match(controller: "catalogo")
        match(controller: "prodotto", action: "schedaProdotto")
        match(controller: "ordine", action: "carrello")


    }

    boolean before() {
        if(session.role == 'amministratore'){
            println("amministratore fa richiesta web")
            redirect controller: 'amministratore', action: 'toolAmministratore'
            return
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
