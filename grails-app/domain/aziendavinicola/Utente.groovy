package aziendavinicola

class Utente {

    String nome
    String cognome
    String email
    String password

    static constraints = {
        nome blank: false
        cognome blank: false
        email blank: false, email: true, unique: true
        password blank: false, password: true
    }
}
