package aziendavinicola

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class FunzioniAmministrativeInterceptorSpec extends Specification implements InterceptorUnitTest<FunzioniAmministrativeInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test funzioniAmministrative interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"funzioniAmministrative")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
