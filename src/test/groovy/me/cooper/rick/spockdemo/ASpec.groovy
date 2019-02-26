package me.cooper.rick.spockdemo

import spock.lang.Specification


class ASpec extends Specification {


    def "I actually want to test add a bunch of times as I can't trust '+'"() {
        given: "nothing... given nothing"

        when: "adding 1 and 2 together"
        def answer = calc.add(1, 2)

        then: "the numbers are magically added to get 3!!"
        answer == 3
    }
}