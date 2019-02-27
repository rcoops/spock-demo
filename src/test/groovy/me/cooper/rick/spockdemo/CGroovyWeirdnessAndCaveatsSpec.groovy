package me.cooper.rick.spockdemo

import spock.lang.Specification
import spock.lang.Title


@Title("Groovy is too gangsta for you")
class CGroovyWeirdnessAndCaveatsSpec extends Specification {

    def calc = new CrapCalc()

    def """This test name is so long that it actually needs multiple lines
to describe what's going on. In fact come to think of it this name is probably going on for a bit longer than necessary
and in my humble opinion this sort of thing should be kept to a minimum unless completely necessary. """() {
        when:
        true

        then:
        true
    }

    def "Groovy doesn't care about your privacy"() {
        expect:
        calc.definitelyPrivateField == "ha! you'll never see me cos: encapsulation right?"
    }

    def "Groovy doesn't care how you define yourself"() {
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

    def "beware blocks!"() {
        expect:
        if (true) {
            false
        }
        if (true) {
            true
        }
    }

}