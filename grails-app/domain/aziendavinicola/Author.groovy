package aziendavinicola

class Author {
    String name
    String surname
    static hasMany = [books: Book]

    static constraints = {
        surname unique: true, blank: false
    }
}
