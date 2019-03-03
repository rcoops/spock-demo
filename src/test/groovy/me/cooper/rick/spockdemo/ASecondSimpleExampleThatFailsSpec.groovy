package me.cooper.rick.spockdemo

import spock.lang.Ignore
import spock.lang.Specification

@Ignore("unless you want to fail")
class ASecondSimpleExampleThatFailsSpec extends Specification {

    def calc = new CrapCalc()

    def "this test has no idea what it's talking about and so will fail"() {
        given: 'nothing... given nothing'

        when: 'adding the 1 and 2'
        def answer = calc.add(1, 2)

        then: 'the numbers are magically added to get ...4?!!'
        answer == 4
    }

    def 'checking string equality'() {
        given: 'some almost identical strings'
        def one = 'I want to compare this string to another string'
        def two = 'I want to compare this string too another string'

        expect: 'they equal! Or do they...?'
        one == two
    }

}
