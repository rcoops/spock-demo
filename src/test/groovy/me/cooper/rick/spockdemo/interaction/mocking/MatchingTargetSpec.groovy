package me.cooper.rick.spockdemo.interaction.mocking

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Specification

@SuppressWarnings("all")
class MatchingTargetSpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper

    def setup() {
        mockyMockWrapper = new MockWrapper(mockyMock)
    }

    def 'matches specific target'() {
        when:
        mockyMockWrapper.doStuff()
        then:
        1 * mockyMock.doOtherStuff()
    }

    def "matches any mock"() {
        when:
        mockyMockWrapper.doStuff()
        then:
        1 * _.doOtherStuff()
    }

    def "matches any method on any mock"() {
        when:
        mockyMockWrapper.doStuff()
        then:
        1 * _._()
    }

    def "matches any method on any mock with any args"() {
        when:
        mockyMockWrapper.doStuff()
        then:
        1 * _._(*_)
    }

    def "matches any method on any mock with any args with less typing"() {
        when:
        mockyMockWrapper.doStuff()
        then:
        1 * _._
    }

    def "matches any method on any mock with any args with even less typing"() {
        when:
        mockyMockWrapper.doStuff()
        then:
        1 * _
    }
}
