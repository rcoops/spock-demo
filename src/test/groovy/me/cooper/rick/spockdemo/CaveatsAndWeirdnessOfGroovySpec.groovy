package me.cooper.rick.spockdemo

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Title


@Title("Groovy is too gangsta for you")
class CaveatsAndWeirdnessOfGroovySpec extends Specification {

    def calc = new CrapCalc()

    def """This test name is so long that it actually needs multiple lines
to describe what's going on. In fact come to think of it this name is probably going on for a bit longer than needed
and in my humble opinion this sort of thing should be kept to a minimum unless completely necessary. """() {
        expect:
        true
    }

    def "Groovy doesn't care about your privacy"() {
        expect:
        calc.definitelyPrivateField == "ha! you'll never see me cos: encapsulation right?"
    }

    def "Groovy doesn't care what you're made of"() {
        given: "We've made up some random tostring method"
        CrapCalc.metaClass.toString = {
            return "I'm a crap calc"
        }

        expect: 'Groovy is ridiculous'
        calc.toString() == "I'm a crap calc"
    }

    def "Groovy Takes what it wants - no returns"() {
        expect: 'MAGIC'
        justEvaluateSomeStuff()
    }

    def justEvaluateSomeStuff() {
        1 == 1 && true && "foo".contains("o")
    }

    def "Groovy doesn't care whether you even exist"() {
        expect: 'MAGIC'
        new NullObjectWrapperWrapper().nullField?.interestingFieldAsLongAsMyParentIsNotNull == null
    }

    def 'Groovy has no class'() {
        expect:
        ''.class == String
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