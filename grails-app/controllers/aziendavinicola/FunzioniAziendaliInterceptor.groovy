package aziendavinicola

// Impedisco ai dipendenti di accedere allo shop online e alle funzioni amministrative
class FunzioniAziendaliInterceptor {
    FunzioniAziendaliInterceptor(){
        matchAll()
                .excludes(controller: "dipendente", action:"toolDipendente")
                .excludes(controller: "fornitura", action:"create")
                .excludes(controller: "fornitura", action:"save")
                .excludes(controller: "ordine", action:"indexOrdiniDaPrendereInCarico")
                .excludes(controller: "ordine", action:"indexOrdiniDaEvadere")
                .excludes(controller: "ordine", action:"show")
                .excludes(controller: "ordine", action:"evadi")
                .excludes(controller: "ordine", action:"prendiInCarico")
                .excludes(controller: "utente", action:"login")
                .excludes(controller: "utente", action:"logout")
                .excludes(controller: "utente", action: "autenticaUtente")
                .excludes(controller: "utente", action: "autenticaUtente")


    }

    boolean before() {
        if(session.role == 'dipendente'){
            println("dipendente fa richiesta web")
            redirect controller: 'dipendente', action: 'toolDipendente'
            return
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
