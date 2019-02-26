package me.cooper.rick.spockdemo

import spock.lang.Specification
import spock.lang.Title


@Title("Groovy is too gangsta for you")
class YSpec extends Specification {

    def calc = new CrapCalc()

    def "Groovy doesn't care about your privacy"() {
        expect:
        calc.definitelyPrivateField == "ha! you'll never see me cos: encapsulation right?"
    }

    def "Groovy doesn't care who you think you are"() {
        given: "We've made up some random tostring method"
        CrapCalc.metaClass.toString = {
            return "I'm a crap calc"
        }

        expect: 'Groovy is ridiculous'
        calc.toString() == "I'm a crap calc"
    }

    def "Groovy doesn't care about if you don't exist"() {
        expect: 'MAGIC'
        new NullObjectWrapperWrapper().nullField?.interestingFieldAsLongAsMyParentIsNotNull == null
    }

    def "Groovy Takes what it wants"() {
        expect: 'MAGIC'
        justEvaluateSomeStuff()
    }

    def justEvaluateSomeStuff() {
        1 == 1 && true && "foo".contains("o")
    }

    class NullObjectWrapperWrapper {
        ObjectWrapper nullField = null
    }

    class ObjectWrapper {
        Object interestingFieldAsLongAsMyParentIsNotNull = new Object()
    }

}