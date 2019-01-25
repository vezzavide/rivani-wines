package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VitignoServiceSpec extends Specification {

    VitignoService vitignoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vitigno(...).save(flush: true, failOnError: true)
        //new Vitigno(...).save(flush: true, failOnError: true)
        //Vitigno vitigno = new Vitigno(...).save(flush: true, failOnError: true)
        //new Vitigno(...).save(flush: true, failOnError: true)
        //new Vitigno(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vitigno.id
    }

    void "test get"() {
        setupData()

        expect:
        vitignoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vitigno> vitignoList = vitignoService.list(max: 2, offset: 2)

        then:
        vitignoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vitignoService.count() == 5
    }

    void "test delete"() {
        Long vitignoId = setupData()

        expect:
        vitignoService.count() == 5

        when:
        vitignoService.delete(vitignoId)
        sessionFactory.currentSession.flush()

        then:
        vitignoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vitigno vitigno = new Vitigno()
        vitignoService.save(vitigno)

        then:
        vitigno.id != null
    }
}
