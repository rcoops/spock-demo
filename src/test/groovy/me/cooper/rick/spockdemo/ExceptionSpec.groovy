package me.cooper.rick.spockdemo

import spock.lang.Specification

class ExceptionSpec extends Specification {

    def calc = new CrapCalc()

    def "null throws null pointer - who knew!"() {
        when: 'accessing a null field'
        new Encapsulated().nullField.interestingFieldAsLongAsMyParentIsNotNull

        then: 'EXPLOSION!'
        thrown(NullPointerException)
    }

    def "no illegal args"() {
        when:
        calc.add(1, 2)

        then: 'EXPLOSION!'
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
        // NullPointerException thrown = thrown()
        thrown.cause == f
        thrown.message == "oh noes!"
    }
}