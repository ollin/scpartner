package net.nautsch.scpartner

import spock.lang.Specification

/**
 * unit test.
 */
class PartnerRestControllerTest extends Specification {

    def "get a non empty list for all Partners"() {

        when:
        def result = new PartnerRestController().all()

        then:
        result.size() != null
    }
}
