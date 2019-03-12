package me.cooper.rick.spockdemo.interaction

import me.cooper.rick.spockdemo.Mockable
import me.cooper.rick.spockdemo.MockWrapper
import spock.lang.Shared
import spock.lang.Specification

import static org.hamcrest.Matchers.endsWith
import static org.hamcrest.Matchers.greaterThan

class FakeStuffSpec extends Specification {

    def mockyMock
    def mockyMockWrapper

    def setup() {
        mockyMock = Mock(Mockable)
        mockyMockWrapper = new MockWrapper(mockyMock)
    }

    def 'does stuff'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: 'it delegates'
        1 * mockyMock.doStuff()
        0 * _._
        // OR 0 * _
    }

    def 'strict mocking'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()

        then: 'it maybe calls the mock but definitely nothing else'
        _ * mockyMock.doStuff()
        0 * _._
        // OR 0 * _
    }

    def 'does... some kind of stuff?'() {
        when: 'wrapper does stuff'
        mockyMockWrapper.doStuff()
        then: 'it delegates... somewhere'
        1 * mockyMock./do.*Stuff/()
        // TODO argument constraints
        // hamcrest matchers
//        1 * subscriber.receive("hello")        // an argument that is equal to the String "hello"
//        1 * subscriber.receive(!"hello")       // an argument that is unequal to the String "hello"
//        1 * subscriber.receive()               // the empty argument list (would never match in our example)
//        1 * subscriber.receive(_)              // any single argument (including null)
//        1 * subscriber.receive(*_)             // any argument list (including the empty argument list)
//        1 * subscriber.receive(!null)          // any non-null argument
//        1 * subscriber.receive(_ as String)    // any non-null argument that is-a String
//        1 * subscriber.receive(endsWith("lo")) // any non-null argument that is-a String
//        1 * subscriber.receive({ it.size() > 3 && it.contains('a') })
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
