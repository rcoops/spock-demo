package me.cooper.rick.spockdemo.interaction

import me.cooper.rick.spockdemo.CrapCalc
import spock.lang.Specification

@SuppressWarnings("all")
class SpySpec extends Specification {

    def calc = Spy(CrapCalc)

    def "tests interactions"() {
        given: 'some numbers'
        def numbers = [1, 2, 3].toArray(new int[0])
        def totalAdditions = numbers.length - 1

        when:
        calc.addAll(numbers)

        then:
        totalAdditions * calc.add(_, _) >> 2
    }
}
