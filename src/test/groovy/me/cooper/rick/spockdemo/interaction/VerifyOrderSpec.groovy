package me.cooper.rick.spockdemo.interaction

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Specification

@SuppressWarnings("all")
class VerifyOrderSpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper

    def setup() {
        mockyMockWrapper = new MockWrapper(mockyMock)
    }

    def 'does stuff in order'() {
        when:
        mockyMockWrapper.doStuffInOrder()

        then: 'first calls one'
        1 * mockyMock.one()
        then: 'calls two'
        1 * mockyMock.two()
        then: 'calls three'
        1 * mockyMock.three()
    }

}