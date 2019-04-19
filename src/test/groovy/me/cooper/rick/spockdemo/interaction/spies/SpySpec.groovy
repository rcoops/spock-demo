package me.cooper.rick.spockdemo.interaction.spies

import me.cooper.rick.spockdemo.CrapCalc
import spock.lang.Specification

@SuppressWarnings("all")
class SpySpec extends Specification {

    def calc = Spy(CrapCalc)

    def 'tests interactions on a real thing'() {
        given: 'an array of numbers summing 6'
        def numbers = [1, 2, 3] as int[]

        when: 'adding them all'
        def result = calc.addAll(numbers)

        then: 'add is performed one less time than the size of the array'
        (numbers.length - 1) * calc.add(_, _)
        and: 'the result is the sum of the array'
        result == 6
    }
}
