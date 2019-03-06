package aziendavinicola

class LineaOrdine {
    int quantita
    static belongsTo = [ordine: Ordine]
    Annata annata

    static constraints = {
        ordine()
        quantita min: 0
        annata()
    }

    String toString(){
        try{
            annata.toString() + " x " + quantita.toString()
        }
        catch(NullPointerException){
            super.toString()
        }
    }

    BigDecimal getTotal(){
        return  annata.prezzo * quantita
    }
}
