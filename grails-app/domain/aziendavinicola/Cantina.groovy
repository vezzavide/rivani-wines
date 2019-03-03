package aziendavinicola

class Cantina {
    String nome

    static hasMany = [prodotti: Prodotto]

    static constraints = {
        nome blank: false
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