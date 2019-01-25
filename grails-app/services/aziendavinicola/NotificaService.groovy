package aziendavinicola

import grails.gorm.services.Service

@Service(Notifica)
interface NotificaService {

    Notifica get(Serializable id)

    List<Notifica> list(Map args)

    Long count()

    void delete(Serializable id)

    Notifica save(Notifica notifica)

}