package me.cooper.rick.spockdemo.introduction

import me.cooper.rick.spockdemo.Encapsulated
import me.cooper.rick.spockdemo.MockWrapper
import me.cooper.rick.spockdemo.Mockable
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Title

import static me.cooper.rick.spockdemo.Fixtures.calc
import static me.cooper.rick.spockdemo.Fixtures.encapsulated

@Title("Groovy is too gangsta for you")
@Stepwise
@SuppressWarnings("all")
class CaveatsAndWeirdnessOfGroovySpec extends Specification {

    def mockyMock = Mock(Mockable)
    def mockyMockWrapper = new MockWrapper(mockyMock)

    def """This test name is so long that it actually needs multiple lines to describe what's going on. In fact come to
think of it this name is probably going on for a bit longer than needed and in my humble opinion this sort of thing
should be kept to a minimum unless completely necessary."""() {
        expect:
        true
    }

    def "Groovy doesn't respect your privacy"() {
        expect: "it takes 'private' as a suggestion rather than a rule"
        Encapsulated.definitelyPrivateField == "ha! you'll never see me cos: encapsulation right?"
    }

    def "Groovy doesn't 'get' it... or does it?"() {
        expect:
        encapsulated.myField == 2
    }

    def "Groovy won't brace you for the result"() {
        when: 'calling a method with a lot of args (as the last call on that line)'
        def answer = calc.addAll 10, 5, 6, 8
        then: "it doesn't need parenthesis"
        answer == 29
    }

//    @ConfineMetaClassChanges([Encapsulated]) // (stepwise)
    def "Groovy doesn't care what you're made of"() {
        given: "We've made up some random toString method"
        Encapsulated.metaClass.toString = {
            return "I'm not real!"
        }

        expect: 'Groovy is ridiculous'
        encapsulated.toString() == "I'm not real!"
    }

//    @Ignore('unless you want to fail')
    def "...it still doesn't care"() {
        expect: 'Groovy is ridiculously ridiculous'
        encapsulated.toString() == "I'm not real!"
    }

    def "Groovy Takes what it wants - no returns"() {
        expect: 'MAGIC'
        gimme() == "some stuff"
    }

    def gimme() {
        "some stuff"
    }

    def "Groovy doesn't even care if you exist"() {
        expect: 'in normal circumstances, a null pointer exception'
        encapsulated.nullField?.interestingFieldAsLongAsMyParentIsNotNull == null
    }

    def "Groovy ain't got no class"() {
        expect:
        ''.class == String
    }

    def "Groovy doesn't care if you take exception!"() {
        when:
        throwCheckedExceptionWithoutActuallyChecking()
        then:
        thrown IOException
    }

    def throwCheckedExceptionWithoutActuallyChecking() {
        throw new IOException()
    }

    def 'beware brackets!'() {
        expect: 'true AND false??'
        if (true) {
            false
        }
        if (true) {
            true
        }
    }

    @Ignore('unless you want to fail')
    def "deal with brackets!"() {
        expect: 'true AND false??'
        if (true) {
            assert false
        }
        if (true) {
            assert true
        }
    }

    @Ignore('unless you want to fail')
    def "this no worky"() {
        given: 'mockmock is stubbed'
        mockyMock.getStuff() >> "stuff"

        when: 'getting stuff'
        def stuff = mockyMockWrapper.getStuff()

        then: 'stuff is got'
        1 * mockyMock.getStuff()
        stuff == "stuff"
    }

    def "this works"() {
        when: 'getting stuff'
        def stuff = mockyMockWrapper.getStuff()

        then: 'stuff is got'
        1 * mockyMock.getStuff() >> "stuff"
        stuff == "stuff"
    }
}
