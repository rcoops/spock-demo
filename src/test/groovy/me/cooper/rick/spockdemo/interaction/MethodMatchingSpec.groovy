package me.cooper.rick.spockdemo.interaction

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Specification

@SuppressWarnings("all")
class MethodMatchingSpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper

    def setup() {
        mockyMockWrapper = new MockWrapper(mockyMock)
    }

    def 'does stuff with doStuff'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: 'it calls doStuff on the delegate'
        1 * mockyMock.doStuff()
    }

    def 'gets stuff with getStuff'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.getStuff()

        then: 'it calls doStuff on the delegate'
        1 * mockyMock.stuff
    }

    def 'does stuff... somehow'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: 'it calls...something on the delegate WITHOUT args'
        1 * mockyMock._()
    }

    def 'does stuff... dont care how or with what'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuffWithArgs()

        then: 'it calls...something on the delegate with 0 or more args'
        1 * mockyMock._
        // EQUIVALENT TO 1 * mockyMock._(*_)
    }

    def 'does stuff with something resembling a method'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: "it calls...something beginning with d and ending with 2 'f's on the delegate"
        1 * mockyMock./d.*f{2}/()
    }

}