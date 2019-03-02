package aziendavinicola

class LineaOrdine {
    int quantita
    static belongsTo = [ordine: Ordine]
    Annata annata

    static constraints = {
        ordine()
        quantita notEqual: 0
        annata()
    }
}
