package aziendavinicola

import grails.gorm.services.Service

@Service(Prodotto)
interface ProdottoService {

    Prodotto get(Serializable id)

    List<Prodotto> list(Map args)

    Long count()

    void delete(Serializable id)

    Prodotto save(Prodotto prodotto)

}