package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrdineServiceSpec extends Specification {

    OrdineService ordineService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ordine(...).save(flush: true, failOnError: true)
        //new Ordine(...).save(flush: true, failOnError: true)
        //Ordine ordine = new Ordine(...).save(flush: true, failOnError: true)
        //new Ordine(...).save(flush: true, failOnError: true)
        //new Ordine(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ordine.id
    }

    void "test get"() {
        setupData()

        expect:
        ordineService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ordine> ordineList = ordineService.list(max: 2, offset: 2)

        then:
        ordineList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ordineService.count() == 5
    }

    void "test delete"() {
        Long ordineId = setupData()

        expect:
        ordineService.count() == 5

        when:
        ordineService.delete(ordineId)
        sessionFactory.currentSession.flush()

        then:
        ordineService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ordine ordine = new Ordine()
        ordineService.save(ordine)

        then:
        ordine.id != null
    }
}
