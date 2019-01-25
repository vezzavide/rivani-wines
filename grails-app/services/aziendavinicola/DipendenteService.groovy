package aziendavinicola

import grails.gorm.services.Service

@Service(Dipendente)
interface DipendenteService {

    Dipendente get(Serializable id)

    List<Dipendente> list(Map args)

    Long count()

    void delete(Serializable id)

    Dipendente save(Dipendente dipendente)

}