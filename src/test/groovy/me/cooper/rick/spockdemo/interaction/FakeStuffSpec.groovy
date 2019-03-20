package me.cooper.rick.spockdemo.interaction

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Specification

class FakeStuffSpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper

    def setup() {
        mockyMockWrapper = new MockWrapper(mockyMock)
    }

    def 'does stuff'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: 'it delegates'
        1 * mockyMock.doStuff()
    }

    def 'strict mocking'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: 'it maybe calls the mock but definitely nothing else'
        _ * mockyMock.doStuff()
        0 * _._(*_)
        // OR 0 * _._
        // OR 0 * _
    }

    def 'does... some kind of stuff?'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()
        then: 'it delegates... somewhere'
        1 * mockyMock./do.*Stuff/()
    }

    def 'check some args are passed'() {
        when: 'doing stuff with some args'
        mockyMockWrapper.doStuffWithArgs()

        then: 'stuff is coincidentally done with a string of equal length anc containing an exclamation mark'
        1 * mockyMock.doStuff(*_)
    }

    def 'does stuff at least once'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuffRandomTimes()

        then: 'it makes things happen at least once'
        (1.._) * mockyMock.doStuff()
    }

    def 'does stuff zero or more times'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuffRandomTimes()

        then: 'it makes things happen at least once'
        _ * mockyMock.doStuff()
    }

    def "does things 2"() {
        def mockyMock = Mock(Mockable) {
            doStuff:
            {
                print "I'm replacing what happens in the class ha"
            }
        }
        def mockyMockWrapper = new MockWrapper(mockyMock)
        when:
        mockyMockWrapper.doStuff()
        then:
        1 * mockyMock.doStuff()
        0 * _
    }
}
