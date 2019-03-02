package aziendavinicola

import grails.gorm.services.Service

@Service(LineaOrdine)
interface LineaOrdineService {

    LineaOrdine get(Serializable id)

    List<LineaOrdine> list(Map args)

    Long count()

    void delete(Serializable id)

    LineaOrdine save(LineaOrdine lineaOrdine)

}