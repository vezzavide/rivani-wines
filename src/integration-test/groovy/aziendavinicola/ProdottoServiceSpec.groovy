package aziendavinicola

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProdottoServiceSpec extends Specification {

    ProdottoService prodottoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Prodotto(...).save(flush: true, failOnError: true)
        //new Prodotto(...).save(flush: true, failOnError: true)
        //Prodotto prodotto = new Prodotto(...).save(flush: true, failOnError: true)
        //new Prodotto(...).save(flush: true, failOnError: true)
        //new Prodotto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //prodotto.id
    }

    void "test get"() {
        setupData()

        expect:
        prodottoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Prodotto> prodottoList = prodottoService.list(max: 2, offset: 2)

        then:
        prodottoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        prodottoService.count() == 5
    }

    void "test delete"() {
        Long prodottoId = setupData()

        expect:
        prodottoService.count() == 5

        when:
        prodottoService.delete(prodottoId)
        sessionFactory.currentSession.flush()

        then:
        prodottoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Prodotto prodotto = new Prodotto()
        prodottoService.save(prodotto)

        then:
        prodotto.id != null
    }
}
