package me.cooper.rick.spockdemo.miscellaneous

import spock.lang.Specification

import static me.cooper.rick.spockdemo.Fixtures.calc
import static me.cooper.rick.spockdemo.Fixtures.encapsulated

class ExceptionSpec extends Specification {

    def "null throws null pointer - who knew!"() {
        when: 'accessing a null field'
        encapsulated.nullField.interestingFieldAsLongAsMyParentIsNotNull

        then: 'EXPLOSION!'
        thrown(NullPointerException)
        // OR NullPointerException thrown = thrown()
    }

    def "check that add allows ints.. quite redundantly"() {
        when: 'adding 1 and 2'
        calc.add 1, 2

        then: 'nothing'
        notThrown(IllegalArgumentException)
    }

    def "Exception Inspection"() {
        given: 'a rebel WITH a cause'
        def f = new IllegalArgumentException()
        def e = new Exception("oh noes!", f)

        when: 'it gets thrown'
        throw e

        then: 'EXPLOSION! with detail'
        def thrown = thrown(Exception)
        thrown.cause == f
        thrown.message == "oh noes!"
    }
}