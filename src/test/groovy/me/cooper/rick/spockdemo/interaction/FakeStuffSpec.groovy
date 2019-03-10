package me.cooper.rick.spockdemo.interaction

import me.cooper.rick.spockdemo.ClassToMock
import me.cooper.rick.spockdemo.ClassToMockWrapper
import spock.lang.Specification

class FakeStuffSpec extends Specification {

    def mockyMock = Mock(ClassToMock)
    def mockyMockWrapper = new ClassToMockWrapper(mockyMock)

    def "does things"() {
        when:
        mockyMockWrapper.doStuffWithMock()
        then:
        1 * mockyMock./do.*ff/()
        0 * mockyMock./arrgh/()
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

    def "does things 2"() {
        def mockyMock = Mock(ClassToMock) {
            doStuff:
            {
                print "I'm replacing what happens in the class ha"
            }
        }
        def mockyMockWrapper = new ClassToMockWrapper(mockyMock)
        when:
        mockyMockWrapper.doStuffWithMock()
        then:
        1 * mockyMock.doStuff()
        0 * _
    }
}