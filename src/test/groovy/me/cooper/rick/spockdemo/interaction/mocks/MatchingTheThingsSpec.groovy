package me.cooper.rick.spockdemo.interaction.mocks

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.PendingFeature
import spock.lang.Specification

@SuppressWarnings("all")
class MatchingTheThingsSpec extends Specification {

    // This sort of wild-carding is useful for strict(er) interaction testing
    // i.e. it's ok to call something here, but not ok to call anything else: 0 * _

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper = new MockWrapper(mockyMock)

    /* Matching exact things */

    def 'matches exact method on target'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: 'it calls doOtherStuff on the delegate'
        1 * mockyMock.doOtherStuff()
    }

    /* Matching methods */

    def 'matches getter as groovy property'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.getStuff()

        then: 'it calls getStuff on the delegate'
        1 * mockyMock.stuff
    }

    def 'matches any 0 arg method'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: 'it calls...something on the delegate WITHOUT args'
        1 * mockyMock._()
    }

    def 'matches any method'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuffWithArgs()

        then: 'it calls...something on the delegate with 0 or more args'
        1 * mockyMock._(*_)
    }

    def 'matches any method (with less typing)'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuffWithArgs()

        then: 'it calls...something on the delegate with 0 or more args'
        1 * mockyMock._
    }

    def 'matches groovy regex (ugh!)'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: "it calls...something beginning with d and ending with 2 'f's on the delegate"
        1 * mockyMock./d.*f{2}/()
    }

    /* Matching targets */

    def 'matches any mock'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: '...something does other stuff'
        1 * _.doOtherStuff()
    }

    def 'matches any method on any mock'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: '...something does other stuff without args'
        1 * _._()
    }

    def 'matches any method on any mock with any args'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: '...something does other stuff with OR without args'
        1 * _._(*_)
    }

    def 'matches any method on any mock with any args (with less typing)'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: '...something does other stuff with OR without args'
        1 * _._
    }

    def 'matches any method on any mock with any args (with even LESS typing)'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: '...something does other stuff with OR without args'
        1 * _
    }
}
