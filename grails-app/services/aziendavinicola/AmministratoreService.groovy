package aziendavinicola

import grails.gorm.services.Service

@Service(Amministratore)
interface AmministratoreService {

    Amministratore get(Serializable id)

    List<Amministratore> list(Map args)

    Long count()

    void delete(Serializable id)

    Amministratore save(Amministratore amministratore)

}