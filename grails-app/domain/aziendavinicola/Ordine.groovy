package aziendavinicola

import javax.sound.sampled.Line
import java.text.DecimalFormat

class Ordine {
    Date data
    BigDecimal importo
    // dipendente che ha preso in carico l'ordine
    Dipendente dipendente
    static hasMany = [lineaOrdine: LineaOrdine]

    static constraints = {
        data()
        importo()
        dipendente nullable: true
        lineaOrdine()
    }
}
