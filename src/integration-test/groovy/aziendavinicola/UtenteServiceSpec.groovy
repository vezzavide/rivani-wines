package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UtenteServiceSpec extends Specification {

    UtenteService utenteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Utente(...).save(flush: true, failOnError: true)
        //new Utente(...).save(flush: true, failOnError: true)
        //Utente utente = new Utente(...).save(flush: true, failOnError: true)
        //new Utente(...).save(flush: true, failOnError: true)
        //new Utente(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //utente.id
    }

    void "test get"() {
        setupData()

        expect:
        utenteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Utente> utenteList = utenteService.list(max: 2, offset: 2)

        then:
        utenteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        utenteService.count() == 5
    }

    void "test delete"() {
        Long utenteId = setupData()

        expect:
        utenteService.count() == 5

        when:
        utenteService.delete(utenteId)
        sessionFactory.currentSession.flush()

        then:
        utenteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Utente utente = new Utente()
        utenteService.save(utente)

        then:
        utente.id != null
    }
}
