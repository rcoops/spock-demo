package me.cooper.rick.spockdemo

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Title


@Title("Groovy is too gangsta for you")
class CaveatsAndWeirdnessOfGroovySpec extends Specification {

    def calc = new CrapCalc()

    def """This test name is so long that it actually needs multiple lines to describe what's going on. In fact come to
think of it this name is probably going on for a bit longer than needed and in my humble opinion this sort of thing
should be kept to a minimum unless completely necessary. """() {
        expect:
        true
    }

    def "Groovy doesn't care about your privacy"() {
        expect: "it takes 'private' as a suggestion rather than a rule"
        Encapsulated.definitelyPrivateField == "ha! you'll never see me cos: encapsulation right?"
    }

    def "Groovy doesn't 'get' it... or does it?"() {
        def x = new Encapsulated()
        expect:
        x.myField == 2
    }

    def "Groovy doesn't care what you're made of"() {
        given: "We've made up some random toString method"
        Encapsulated.metaClass.toString = {
            return "I'm a crap calc"
        }

        expect: 'Groovy is ridiculous'
        new Encapsulated().toString() == "I'm a crap calc"
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
        new Encapsulated().nullField?.interestingFieldAsLongAsMyParentIsNotNull == null
    }

    def "Groovy ain't got no class"() {
        expect:
        ''.class == String
    }

    def "Groovy doesn't care if you take exception!"() {
        when:
        throwCheckedExceptionWithoutActuallyChecking()
        then:
        thrown(IOException)
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

    @Ignore("Un-ignore me to fail")
    def "deal with brackets!"() {
        expect: 'true AND false??'
        if (true) {
            assert false
        }
        if (true) {
            assert true
        }
    }

}