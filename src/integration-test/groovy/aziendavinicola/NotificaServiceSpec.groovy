package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class NotificaServiceSpec extends Specification {

    NotificaService notificaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Notifica(...).save(flush: true, failOnError: true)
        //new Notifica(...).save(flush: true, failOnError: true)
        //Notifica notifica = new Notifica(...).save(flush: true, failOnError: true)
        //new Notifica(...).save(flush: true, failOnError: true)
        //new Notifica(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //notifica.id
    }

    void "test get"() {
        setupData()

        expect:
        notificaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Notifica> notificaList = notificaService.list(max: 2, offset: 2)

        then:
        notificaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        notificaService.count() == 5
    }

    void "test delete"() {
        Long notificaId = setupData()

        expect:
        notificaService.count() == 5

        when:
        notificaService.delete(notificaId)
        sessionFactory.currentSession.flush()

        then:
        notificaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Notifica notifica = new Notifica()
        notificaService.save(notifica)

        then:
        notifica.id != null
    }
}
