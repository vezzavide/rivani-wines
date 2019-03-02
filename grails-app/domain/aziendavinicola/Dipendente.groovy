package aziendavinicola

class Dipendente extends Utente {
    Boolean responsabileMagazzino

    static hasMany = [ordini: Ordine, forniture: Fornitura]


    static constraints = {
    }
}
