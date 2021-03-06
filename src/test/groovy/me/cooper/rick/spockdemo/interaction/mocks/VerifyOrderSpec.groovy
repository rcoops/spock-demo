package me.cooper.rick.spockdemo.interaction.mocks

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Specification

@SuppressWarnings("all")
class VerifyOrderSpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper = new MockWrapper(mockyMock)

    def 'does stuff in order'() {
        when: 'doing stuff in order'
        mockyMockWrapper.doStuffInOrder()

        then: 'calls one'
        1 * mockyMock.one()
        then: 'calls two' // Note 'then' rather than 'and'
        1 * mockyMock.two()
        then: 'calls three'
        1 * mockyMock.three()
    }
}
