package aziendavinicola

import java.text.DecimalFormat
import java.time.Instant
import java.time.Year

class Annata {
    int anno
    String note
    BigDecimal prezzo
    int totaleBottiglieProdotte
    int giacenza

    Prodotto prodotto
    static belongsTo = Prodotto
    static hasMany = [notifiche: Notifica]

    static constraints = {
        notifiche display: false
        // anno-prodotto costituisce una chiave univoca
        anno unique: 'prodotto', min: 1800,  max: Year.now().getValue()
        prodotto()
        // tentativo di ottenere campo TEXT in mysql (e/o altri db)
        prezzo notEqual: BigDecimal.ZERO
        giacenza()
        totaleBottiglieProdotte notEqual: 0
        note size: 0..65535, widget: 'textarea'
    }

    String toString(){
        try{
            String annataToString = prodotto + " del " + anno
            annataToString.capitalize()
        }
        catch(NullPointerException){
            super.toString()
        }
    }
}
