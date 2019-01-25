package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AmministratoreServiceSpec extends Specification {

    AmministratoreService amministratoreService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Amministratore(...).save(flush: true, failOnError: true)
        //new Amministratore(...).save(flush: true, failOnError: true)
        //Amministratore amministratore = new Amministratore(...).save(flush: true, failOnError: true)
        //new Amministratore(...).save(flush: true, failOnError: true)
        //new Amministratore(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //amministratore.id
    }

    void "test get"() {
        setupData()

        expect:
        amministratoreService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Amministratore> amministratoreList = amministratoreService.list(max: 2, offset: 2)

        then:
        amministratoreList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        amministratoreService.count() == 5
    }

    void "test delete"() {
        Long amministratoreId = setupData()

        expect:
        amministratoreService.count() == 5

        when:
        amministratoreService.delete(amministratoreId)
        sessionFactory.currentSession.flush()

        then:
        amministratoreService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Amministratore amministratore = new Amministratore()
        amministratoreService.save(amministratore)

        then:
        amministratore.id != null
    }
}
