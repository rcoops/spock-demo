package me.cooper.rick.spockdemo

import spock.lang.Specification


class ASpec extends Specification {

    def calc = new CrapCalc()

    def 'I want to make sure that adding 1 to 2 results in 3 and this test will do that (and very well thank you)!'() {
        given: 'nothing... given nothing'

        when: 'adding the 1 and 2'
        def answer = calc.add(1, 2)

        then: 'the numbers are magically added to get 3!!'
        answer == 3
    }

    def 'this test is really just to show you the output of a failed test'() {
        given: 'nothing... given nothing'

        when: 'adding the 1 and 2'
        def answer = calc.add(1, 2)

        then: 'the numbers are magically added to get ...4?!!'
        answer == 4
    }

}