package me.cooper.rick.spockdemo.interaction

import spock.lang.Specification

import static org.hamcrest.Matchers.greaterThan

class ArgumentMatchingSpec extends Specification {

    def 'check arg conditions'() {
        when: 'doing stuff with the string'
        mockyMockWrapper.doStuffWithArgs()

        then: 'stuff is coincidentally done with a string of equal length anc containing an exclamation mark'
        1 * mockyMock.doStuff('Hello World!', greaterThan(2), !6.0f)
    }

    def 'check arg conditions 2'() {
        when: 'doing stuff with some args'
        mockyMockWrapper.doStuffWithArgs()

        then: 'stuff is coincidentally done with a string of equal length anc containing an exclamation mark'
        1 * mockyMock.doStuff(_ as String, { it < 20 && it > 0 }, !null)
    }

    def "i only care how many times it's called"() {
        when: 'doing stuff with the string'
        mockyMockWrapper.doStuff(string)

        then: 'stuff is coincidentally done with a string of equal length anc containing an exclamation mark'
        1 * mockyMock.doStuff(_)
    }

}