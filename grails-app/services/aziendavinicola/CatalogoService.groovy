package aziendavinicola

import grails.gorm.services.Service

@Service(Catalogo)
interface CatalogoService {

    Catalogo get(Serializable id)

    List<Catalogo> list(Map args)

    Long count()

    void delete(Serializable id)

    Catalogo save(Catalogo catalogo)

}