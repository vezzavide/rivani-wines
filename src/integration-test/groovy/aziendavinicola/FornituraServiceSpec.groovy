package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FornituraServiceSpec extends Specification {

    FornituraService fornituraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Fornitura(...).save(flush: true, failOnError: true)
        //new Fornitura(...).save(flush: true, failOnError: true)
        //Fornitura fornitura = new Fornitura(...).save(flush: true, failOnError: true)
        //new Fornitura(...).save(flush: true, failOnError: true)
        //new Fornitura(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fornitura.id
    }

    void "test get"() {
        setupData()

        expect:
        fornituraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Fornitura> fornituraList = fornituraService.list(max: 2, offset: 2)

        then:
        fornituraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fornituraService.count() == 5
    }

    void "test delete"() {
        Long fornituraId = setupData()

        expect:
        fornituraService.count() == 5

        when:
        fornituraService.delete(fornituraId)
        sessionFactory.currentSession.flush()

        then:
        fornituraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Fornitura fornitura = new Fornitura()
        fornituraService.save(fornitura)

        then:
        fornitura.id != null
    }
}
