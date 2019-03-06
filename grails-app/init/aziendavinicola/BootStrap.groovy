package aziendavinicola

class BootStrap {

    def init = { servletContext ->
        try{
            def amministratore = new Amministratore(
                    nome: "Admin",
                    cognome: "Admin",
                    email: "admin@rivaniwines.com",
                    password: "password",
                    responsabileMagazzino: false,
            ).save(flush: true)
        } catch (Exception e){

        }
    }
    def destroy = {
    }
}
