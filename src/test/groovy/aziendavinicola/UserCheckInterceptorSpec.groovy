package aziendavinicola

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class UserCheckInterceptorSpec extends Specification implements InterceptorUnitTest<UserCheckInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test userCheck interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"userCheck")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
