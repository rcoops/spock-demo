package me.cooper.rick.spockdemo

import spock.lang.Specification


class DemoSpec extends Specification {

    def calc = new CrapCalc()

    def "a really long test name that provides an adequate description in English"() {
        when:
        def x = calc.add(1, 2)
        then:
        x == 3
    }

}