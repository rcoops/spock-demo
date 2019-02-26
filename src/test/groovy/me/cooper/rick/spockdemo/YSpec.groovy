package me.cooper.rick.spockdemo

import spock.lang.Specification
import spock.lang.Title


@Title("Groovy is too gangsta for you")
class YSpec extends Specification {

    def thing = Mock(CrapCalc)
    def calc = new CrapCalc()

    def "Groovy doesn't care about your privacy"() {
        expect:
        calc.youCantSeeMe == 'ha!'
    }

    def "Groovy doesn't care about your static 'types'"() {
        given: "We've made up some random tostring method"
        CrapCalc.metaClass.toString = {
            return "I'm a crap calc"
        }

        expect: 'Groovy is ridiculous'
        calc.toString() == "I'm a crap calc"
    }

}