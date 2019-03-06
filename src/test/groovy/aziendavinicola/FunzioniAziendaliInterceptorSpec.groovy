package aziendavinicola

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class FunzioniAziendaliInterceptorSpec extends Specification implements InterceptorUnitTest<FunzioniAziendaliInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test funzioniAziendali interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"funzioniAziendali")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
