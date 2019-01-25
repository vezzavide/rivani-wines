package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FornitoreServiceSpec extends Specification {

    FornitoreService fornitoreService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Fornitore(...).save(flush: true, failOnError: true)
        //new Fornitore(...).save(flush: true, failOnError: true)
        //Fornitore fornitore = new Fornitore(...).save(flush: true, failOnError: true)
        //new Fornitore(...).save(flush: true, failOnError: true)
        //new Fornitore(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fornitore.id
    }

    void "test get"() {
        setupData()

        expect:
        fornitoreService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Fornitore> fornitoreList = fornitoreService.list(max: 2, offset: 2)

        then:
        fornitoreList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fornitoreService.count() == 5
    }

    void "test delete"() {
        Long fornitoreId = setupData()

        expect:
        fornitoreService.count() == 5

        when:
        fornitoreService.delete(fornitoreId)
        sessionFactory.currentSession.flush()

        then:
        fornitoreService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Fornitore fornitore = new Fornitore()
        fornitoreService.save(fornitore)

        then:
        fornitore.id != null
    }
}
