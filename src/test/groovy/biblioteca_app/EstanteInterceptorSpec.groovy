package biblioteca_app


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(EstanteInterceptor)
class EstanteInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test estante interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"estante")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
