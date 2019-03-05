package aziendavinicola

class Fornitura {
    Date data
    Fornitore fornitore
    // Indica il dipendente che ha inserito la fornitura
    Dipendente dipendente
    Annata annata
    int quantita

    static constraints = {
        data()
        fornitore()
        annata()
        quantita min: 1
        dipendente display: false
    }


}
