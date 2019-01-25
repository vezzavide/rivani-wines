package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CatalogoServiceSpec extends Specification {

    CatalogoService catalogoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Catalogo(...).save(flush: true, failOnError: true)
        //new Catalogo(...).save(flush: true, failOnError: true)
        //Catalogo catalogo = new Catalogo(...).save(flush: true, failOnError: true)
        //new Catalogo(...).save(flush: true, failOnError: true)
        //new Catalogo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //catalogo.id
    }

    void "test get"() {
        setupData()

        expect:
        catalogoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Catalogo> catalogoList = catalogoService.list(max: 2, offset: 2)

        then:
        catalogoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        catalogoService.count() == 5
    }

    void "test delete"() {
        Long catalogoId = setupData()

        expect:
        catalogoService.count() == 5

        when:
        catalogoService.delete(catalogoId)
        sessionFactory.currentSession.flush()

        then:
        catalogoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Catalogo catalogo = new Catalogo()
        catalogoService.save(catalogo)

        then:
        catalogo.id != null
    }
}
