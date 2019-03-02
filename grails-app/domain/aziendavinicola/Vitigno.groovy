package aziendavinicola

class Vitigno {
    String nome
    String caratteristiche
    static hasMany = [prodotti: Prodotto]

    static constraints = {
        nome blank: false
        caratteristiche()
        prodotti()
    }
}