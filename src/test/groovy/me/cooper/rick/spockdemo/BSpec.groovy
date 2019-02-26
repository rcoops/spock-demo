package me.cooper.rick.spockdemo

import spock.lang.Specification


class BSpec extends Specification {

    def """This test name is so long that it actually needs multiple lines
to describe what's going on. In fact come to think of it this name is probably going on for a bit longer than necessary
and in my humble opinion this sort of thing should be kept to a minimum unless completely necessary. """() {
        when:
        true

        then:
        true
    }

    def "test that Groovy is mental"() {
        given: "We've made up some random tostring method"
        CrapCalc.metaClass.toString = {
            return "I'm a crap calc"
        }

        when: "calling a method that doesn't exist in real life"
        def calcString = calc.toString()

        then: 'Groovy is mental'
    }

}