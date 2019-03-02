package aziendavinicola


class Cantina {
    String nome

    static hasMany = [prodotti: Prodotto]

    static constraints = {
    }
}