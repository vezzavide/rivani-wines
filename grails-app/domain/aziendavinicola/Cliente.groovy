package aziendavinicola

class Cliente extends Utente {
    // Per prototipazione per indirizzo basta una String
    String indirizzo
    static hasMany = [notifiche: Notifica, ordini: Ordine]

    static constraints = {
    }

}
