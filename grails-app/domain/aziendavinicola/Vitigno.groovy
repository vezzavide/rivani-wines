package aziendavinicola

class Vitigno {
    String nome
    String caratteristiche

    static belongsTo = Prodotto
    static hasMany = [prodotti: Prodotto]

    static constraints = {
        prodotti display: false
    }
}