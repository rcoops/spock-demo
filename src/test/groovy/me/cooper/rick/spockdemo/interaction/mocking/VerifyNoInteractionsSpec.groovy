package me.cooper.rick.spockdemo.interaction.mocking

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Specification

@SuppressWarnings("all")
class VerifyNoInteractionsSpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper

    def setup() {
        mockyMockWrapper = new MockWrapper(mockyMock)
    }

    def 'no interactions'() {
        when: ''
        mockyMockWrapper.getMock()
        then: ''
        0 * _
    }
}
