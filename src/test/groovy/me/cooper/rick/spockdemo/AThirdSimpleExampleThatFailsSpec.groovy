package me.cooper.rick.spockdemo

import org.junit.Ignore
import spock.lang.Specification

class AThirdSimpleExampleThatFailsSpec extends Specification {

    def calc = new CrapCalc()

    @Ignore
    // TODO remove me
    def "this test has no idea what it's talking about and so will fail"() {
        given: 'nothing... given nothing'

        when: 'adding the 1 and 2'
        def answer = calc.add(1, 2)

        then: 'the numbers are magically added to get ...4?!!'
        answer == 4
    }


}
