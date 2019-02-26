package me.cooper.rick.spockdemo

import spock.lang.Specification


class BSpec extends Specification {

    def calc = new CrapCalc()

    def "I actually think I want to test more than just two numbers as I don't trust '+'"() {
        given: "still nothing interesting happening"

        when:
        def answer = calc.add(x, y)

        then:
        answer = expectedAnswer

        where:
        x << [1, 2, 3]
        y << [1, 2, 3]
        expectedAnswer << [2, 4, 6]
    }
}