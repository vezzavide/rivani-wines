package aziendavinicola

import grails.gorm.services.Service

@Service(Fornitore)
interface FornitoreService {

    Fornitore get(Serializable id)

    List<Fornitore> list(Map args)

    Long count()

    void delete(Serializable id)

    Fornitore save(Fornitore fornitore)

}