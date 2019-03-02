package aziendavinicola

import javax.sound.sampled.Line
import java.text.DecimalFormat

class Ordine {
    int id
    Date data
    BigDecimal importo

    //static belongsTo = [cliente: Cliente]
    Dipendente dipendente // dipendente che ha preso in carico l'ordine
    static hasMany = [lineaOrdine: LineaOrdine]

    static constraints = {
    }
}
