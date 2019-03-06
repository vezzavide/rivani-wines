package aziendavinicola

import javax.sound.sampled.Line
import java.text.DecimalFormat

class Ordine {
    Date data
    //BigDecimal importo
    // Dipendente che ha preso in carico l'ordine.
    // Quando si dovrà mostrare la lista degli ordini da evadere tra cui scegliere, si mostreranno solo quelli
    // con questa proprietà ancora a null
    Dipendente dipendente
    Cliente cliente
    static hasMany = [lineeOrdine: LineaOrdine]
    boolean evaso = false
    // Indica se questo ordine costituisce il carrello attivo del cliente
    boolean attualeCarrello = false

    static constraints = {
        data()
        cliente()
        dipendente nullable: true
        lineeOrdine()
        evaso()
        attualeCarrello()
    }

    BigDecimal getTotal(){
        BigDecimal total = 0
        lineeOrdine.each{
            total += it.annata.prezzo * it.quantita
        }
        return total
    }

    String toString(){
        try{
            "Ordine del " + data.toString() + " di " + cliente.toString() + " per un totale di € " + this.getTotal().toString()
        }
        catch(NullPointerException){
            super.toString()
        }
    }
}
