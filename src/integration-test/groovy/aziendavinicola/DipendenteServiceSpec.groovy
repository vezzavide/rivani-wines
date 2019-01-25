package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DipendenteServiceSpec extends Specification {

    DipendenteService dipendenteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Dipendente(...).save(flush: true, failOnError: true)
        //new Dipendente(...).save(flush: true, failOnError: true)
        //Dipendente dipendente = new Dipendente(...).save(flush: true, failOnError: true)
        //new Dipendente(...).save(flush: true, failOnError: true)
        //new Dipendente(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dipendente.id
    }

    void "test get"() {
        setupData()

        expect:
        dipendenteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Dipendente> dipendenteList = dipendenteService.list(max: 2, offset: 2)

        then:
        dipendenteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dipendenteService.count() == 5
    }

    void "test delete"() {
        Long dipendenteId = setupData()

        expect:
        dipendenteService.count() == 5

        when:
        dipendenteService.delete(dipendenteId)
        sessionFactory.currentSession.flush()

        then:
        dipendenteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Dipendente dipendente = new Dipendente()
        dipendenteService.save(dipendente)

        then:
        dipendente.id != null
    }
}
