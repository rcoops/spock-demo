package me.cooper.rick.spockdemo.interaction

import me.cooper.rick.spockdemo.CrapCalc
import spock.lang.Specification


class SpySpec extends Specification {

    def calc = Spy(CrapCalc)

    def "tests interactions"() {
        given: 'some numbers'
        def numbers = [1, 2, 3]
        def totalAdditions = numbers.size() - 1

        when:
        calc.addAll(numbers.toArray(new int[0]))

        then:
        totalAdditions * calc.add(_, _) >> 2
    }

}