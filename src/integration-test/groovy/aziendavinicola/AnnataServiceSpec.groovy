package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AnnataServiceSpec extends Specification {

    AnnataService annataService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Annata(...).save(flush: true, failOnError: true)
        //new Annata(...).save(flush: true, failOnError: true)
        //Annata annata = new Annata(...).save(flush: true, failOnError: true)
        //new Annata(...).save(flush: true, failOnError: true)
        //new Annata(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //annata.id
    }

    void "test get"() {
        setupData()

        expect:
        annataService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Annata> annataList = annataService.list(max: 2, offset: 2)

        then:
        annataList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        annataService.count() == 5
    }

    void "test delete"() {
        Long annataId = setupData()

        expect:
        annataService.count() == 5

        when:
        annataService.delete(annataId)
        sessionFactory.currentSession.flush()

        then:
        annataService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Annata annata = new Annata()
        annataService.save(annata)

        then:
        annata.id != null
    }
}
