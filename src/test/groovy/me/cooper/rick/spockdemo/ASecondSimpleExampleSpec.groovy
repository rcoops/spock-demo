package me.cooper.rick.spockdemo


import spock.lang.Specification

class ASecondSimpleExampleSpec extends Specification {

    def calc = new CrapCalc()

    def 'I think I can make this test simpler!'() {
        expect: '1 and 2 added together makes...3!'
        calc.add(1, 2) == 3
    }

    // Not double quotes - GString
    def "this test has no idea what it's talking about and so will fail"() {
        given: 'nothing... given nothing'

        when: 'adding the 1 and 2'
        def answer = calc.add(1, 2)

        then: 'the numbers are magically added to get ...4?!!'
        answer == 4
    }

}