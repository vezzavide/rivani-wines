package aziendavinicola

class Prodotto {
    String nome
    String caratteristiche
    Boolean inCatalogo
    static hasMany = [vitigni: Vitigno, annate: Annata]
    Cantina cantina

    static constraints = {
        nome blank: false, unique: true
        caratteristiche()
        vitigni()
        annate()
        cantina()
        inCatalogo()
    }

    String toString(){
        try{
            nome.capitalize()
        }
        catch(NullPointerException){
            super.toString()
        }
    }
}
