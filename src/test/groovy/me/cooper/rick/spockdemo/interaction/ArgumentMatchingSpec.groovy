package me.cooper.rick.spockdemo.interaction

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Specification

import static org.hamcrest.Matchers.greaterThan

@SuppressWarnings("all")
class ArgumentMatchingSpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper

    def setup() {
        mockyMockWrapper = new MockWrapper(mockyMock)
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

    def 'check arg conditions 2'() {
        when: 'doing stuff with some args'
        mockyMockWrapper.doStuffWithArgs()

        then: 'stuff is done with these things'
        1 * mockyMock.doStuff(
                _ as String,
                { it < 20 && it > 0 },
                !null
        )
    }

    def "i only care how many times it's called"() {
        when: 'doing stuff with the string'
        mockyMockWrapper.doStuff("hello world!")

        then: 'stuff is done'
        1 * mockyMock.doStuff(_)
    }

    def "i only care how many times it's called with lots of args"() {
        when: 'doing stuff with the string'
        mockyMockWrapper.doStuffWithArgs()

        then: 'stuff is done'
        1 * mockyMock.doStuff(*_)
    }

}