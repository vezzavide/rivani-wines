package aziendavinicola

import javax.sound.sampled.Line
import java.text.DecimalFormat

class Ordine {
    Date data
    BigDecimal importo
    // Dipendente che ha preso in carico l'ordine.
    // Quando si dovrà mostrare la lista degli ordini da evadere tra cui scegliere, si mostreranno solo quelli
    // con questa proprietà ancora a null
    Dipendente dipendente
    Utente utente
    static hasMany = [lineeOrdine: LineaOrdine]
    boolean evaso = false

    static constraints = {
        data()
        importo()
        utente()
        dipendente nullable: true
        lineeOrdine()
        evaso()
    }
}
