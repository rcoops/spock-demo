package me.cooper.rick.spockdemo.interaction.mocking

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Specification

@SuppressWarnings("all")
class MatchingCardinalitySpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper = new MockWrapper(mockyMock)

    def 'x times'() {
        when: 'wrapper does stuff times 3'
        mockyMockWrapper.doStuffTimes(3)

        then: 'delegate does other stuff three times 0.o omg!!!! :O'
        3 * mockyMock.doOtherStuff()
    }

    def 'min times'() {
        when: 'wrapper does stuff times 3'
        mockyMockWrapper.doStuffTimes(3)

        then: 'delegate does other stuff at least once'
        (1.._) * mockyMock.doOtherStuff()
    }

    def 'max times'() {
        when: 'wrapper does stuff times 3'
        mockyMockWrapper.doStuffTimes(3)

        then: 'delegate does other stuff no more than five times'
        (_..5) * mockyMock.doOtherStuff()
    }

    def 'within times'() {
        when: 'wrapper does stuff times 3'
        mockyMockWrapper.doStuffTimes(3)

        then: 'delegate does other stuff between two and four times'
        (2..4) * mockyMock.doOtherStuff()
    }

    def 'no interactions from delegate'() {
        when: 'wrapper does something un-related to delegate'
        mockyMockWrapper.getMock()

        then: 'delegate is not called at all'
        0 * mockyMock._
    }

    def 'to call or not to call'() {
        when: 'wrapper does stuff times 3'
        mockyMockWrapper.doStuffTimes(3)

        then: 'delegate might have been called... but might not muahahahaha!'
        _ * mockyMock.doOtherStuff()
    }

    def 'no interactions at all from anything (mocked) ever'() {
        when: 'wrapper does something un-related to delegate'

        mockyMockWrapper.getMock()
        then: 'nothing else happens'
        0 * _
    }
}
