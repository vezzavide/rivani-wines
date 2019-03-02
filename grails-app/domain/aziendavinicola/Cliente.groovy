package aziendavinicola

class Cliente extends Utente {
    String indirizzo
    static hasMany = [notifiche: Notifica]

    static constraints = {
    }

}
