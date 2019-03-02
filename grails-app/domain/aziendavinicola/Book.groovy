package aziendavinicola

class Book {
    String title
    //static hasMany = [authors: Author]
    Author author

    static constraints = {
        title unique: true, blank: false
        author nullable: true
    }
}
