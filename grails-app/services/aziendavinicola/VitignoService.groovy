package aziendavinicola

import grails.gorm.services.Service

@Service(Vitigno)
interface VitignoService {

    Vitigno get(Serializable id)

    List<Vitigno> list(Map args)

    Long count()

    void delete(Serializable id)

    Vitigno save(Vitigno vitigno)

}