package me.cooper.rick.spockdemo

import spock.lang.Specification


class DemoSpec extends Specification {

    def calc = new CrapCalc()

    def "I want to make sure that adding 1 to 2 results in 3 and this test will do that!"() {
        given: "nothing... given nothing"

        when: "adding the two numbers"
        def answer = calc.add(1, 2)

        then: "the numbers are magically added!!"
        answer == 3
    }

}
