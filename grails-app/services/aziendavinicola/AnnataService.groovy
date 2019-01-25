package aziendavinicola

import grails.gorm.services.Service

@Service(Annata)
interface AnnataService {

    Annata get(Serializable id)

    List<Annata> list(Map args)

    Long count()

    void delete(Serializable id)

    Annata save(Annata annata)

}