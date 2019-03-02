package aziendavinicola

class Dipendente extends Utente {
    // indica se il dipendente è interessato a ricevere notifiche nel caso di esaurimento scorte
    Boolean responsabileMagazzino
    static hasMany = [ordini: Ordine, forniture: Fornitura]

    static constraints = {
    }
}
