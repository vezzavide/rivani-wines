package aziendavinicola

class Fornitore {
    String nome

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
