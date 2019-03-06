package aziendavinicola

class Notifica {

    //static belongsTo = [cliente: Cliente]
    Cliente cliente
    Annata annata

    static constraints = {
        // La coppia cliente-annata deve essere unica
        cliente unique: 'annata'
    }
}
