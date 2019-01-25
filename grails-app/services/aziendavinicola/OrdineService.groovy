package aziendavinicola

import grails.gorm.services.Service

@Service(Ordine)
interface OrdineService {

    Ordine get(Serializable id)

    List<Ordine> list(Map args)

    Long count()

    void delete(Serializable id)

    Ordine save(Ordine ordine)

}