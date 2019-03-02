package aziendavinicola

class Prodotto {
    int id
    String nome
    String caratteristiche

    static hasMany = [vitigni: Vitigno, annate: Annata]
    Cantina cantina

    static constraints = {
    }
}
