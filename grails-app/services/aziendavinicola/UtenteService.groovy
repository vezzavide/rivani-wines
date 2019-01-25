package aziendavinicola

import grails.gorm.services.Service

@Service(Utente)
interface UtenteService {

    Utente get(Serializable id)

    List<Utente> list(Map args)

    Long count()

    void delete(Serializable id)

    Utente save(Utente utente)

}