package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LineaOrdineServiceSpec extends Specification {

    LineaOrdineService lineaOrdineService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new LineaOrdine(...).save(flush: true, failOnError: true)
        //new LineaOrdine(...).save(flush: true, failOnError: true)
        //LineaOrdine lineaOrdine = new LineaOrdine(...).save(flush: true, failOnError: true)
        //new LineaOrdine(...).save(flush: true, failOnError: true)
        //new LineaOrdine(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //lineaOrdine.id
    }

    void "test get"() {
        setupData()

        expect:
        lineaOrdineService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<LineaOrdine> lineaOrdineList = lineaOrdineService.list(max: 2, offset: 2)

        then:
        lineaOrdineList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        lineaOrdineService.count() == 5
    }

    void "test delete"() {
        Long lineaOrdineId = setupData()

        expect:
        lineaOrdineService.count() == 5

        when:
        lineaOrdineService.delete(lineaOrdineId)
        sessionFactory.currentSession.flush()

        then:
        lineaOrdineService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        LineaOrdine lineaOrdine = new LineaOrdine()
        lineaOrdineService.save(lineaOrdine)

        then:
        lineaOrdine.id != null
    }
}
