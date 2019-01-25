package aziendavinicola

import grails.gorm.services.Service

@Service(Cantina)
interface CantinaService {

    Cantina get(Serializable id)

    List<Cantina> list(Map args)

    Long count()

    void delete(Serializable id)

    Cantina save(Cantina cantina)

}