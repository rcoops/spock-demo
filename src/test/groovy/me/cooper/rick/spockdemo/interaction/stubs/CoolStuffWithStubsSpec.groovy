package me.cooper.rick.spockdemo.interaction.stubs

import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Specification

@SuppressWarnings("all")
class CoolStuffWithStubsSpec extends Specification {

    def stubby = Stub(Mockable) {
        getStuff() >> 'hi'
    }

    def stubWrapper = new MockWrapper(stubby)

    def 'test'() {
        when:
        def result = stubWrapper.getStuff()

        then:
        result == 'hi'
    }
}
