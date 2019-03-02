package aziendavinicola

import java.text.DecimalFormat

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
        anno unique: prodotto // unique constraint definita su anno e prodotto
    }
}
