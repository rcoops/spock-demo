package me.cooper.rick.spockdemo

import spock.lang.Specification


class ExceptionSpec extends Specification {

    def "null throws null pointer - who knew!"() {
        when: 'accessing a null field'
        new NullObjectWrapperWrapper().nullField.interestingFieldAsLongAsMyParentIsNotNull

        then: 'EXPLOSION!'
        thrown(NullPointerException)
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


    def "HashMap accepts null key"() {
        given:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }
}