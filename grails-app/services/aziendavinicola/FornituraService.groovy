package aziendavinicola

import grails.gorm.services.Service

@Service(Fornitura)
interface FornituraService {

    Fornitura get(Serializable id)

    List<Fornitura> list(Map args)

    Long count()

    void delete(Serializable id)

    Fornitura save(Fornitura fornitura)

}