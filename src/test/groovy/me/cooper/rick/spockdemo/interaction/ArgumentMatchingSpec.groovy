package me.cooper.rick.spockdemo.interaction

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Shared
import spock.lang.Specification

import static org.hamcrest.Matchers.greaterThan

@SuppressWarnings("all")
class ArgumentMatchingSpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper

    def setup() {
        mockyMockWrapper = new MockWrapper(mockyMock)
    }

    def "i only care how many times it's called with one arg"() {
        when: 'doing stuff with the string'
        mockyMockWrapper.doStuff("hello world!")

        then: 'stuff is done'
        1 * mockyMock.doStuff(_)
    }

    def 'has to be three args'() {
        when: 'doing stuff with the string'
        mockyMockWrapper.doStuffWithArgs()

        then: 'stuff is done with exactly three things'
        1 * mockyMock.doStuff(_, _, _)
    }

    def "i only care how many times it's called and not about args at all"() {
        when: 'doing stuff with the string'
        mockyMockWrapper.doStuffWithArgs()

        then: 'stuff is done'
        1 * mockyMock.doStuff(*_)
    }

    def 'check arg conditions'() {
        when: 'doing stuff with the string'
        mockyMockWrapper.doStuffWithArgs()

        then: 'stuff is done with these things'
        1 * mockyMock.doStuff(
                'Hello World!',
                greaterThan(2),
                !6.0f
        )
    }

    def 'check some different arg conditions'() {
        given:
        def isBetween = { it, gt, lt -> it > gt && it < lt }
        when: 'doing stuff with some args'
        mockyMockWrapper.doStuffWithArgs()

        then: 'stuff is done with these things'
        1 * mockyMock.doStuff(
                _ as String,
                { it > 0 && it < 20 },
//                { isBetween(it, 0, 20) },
                !null
        )
    }
}