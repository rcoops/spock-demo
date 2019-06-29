package me.cooper.rick.spockdemo.introduction

import spock.lang.Specification

import static me.cooper.rick.spockdemo.Fixtures.calc

class AFirstSimpleExampleSpec extends Specification {

    def 'I want to make sure that adding 1 to 1 results in 2 and this test will do that (and very well thank you)!'() {
        given: 'nothing... given nothing'

        when: 'adding the 1 and 1 together'
        def answer = calc.add 1, 1

        then: 'the numbers are magically added to get 2!!'
        answer == 2

        cleanup: 'completely unnecessary cleanup'
        answer = null
    }

    def 'I think I can make this test simpler!'() {
        expect: '1 and 1 added together makes...2!'
        calc.add(1, 1) == 2
    }
}
