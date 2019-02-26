package me.cooper.rick.spockdemo


import spock.lang.Specification

class DemoSpec extends Specification {

    def calc = new CrapCalc()

    def "I actually want to test add a bunch of times as I can't trust '+'"() {
        given: "nothing... given nothing"

        when: "adding the two numbers"
        def answer = calc.add(x, y)

        then: "the numbers are magically added!!"
        answer == expectedAnswer

        where:
        x << [1, 2, 3]
        y << [1, 2, 3]
        expectedAnswer << [2, 4, 6]
    }

    def "Let's test the really really advanced addall logic now"() {
        given: "nothing... given nothing"

        when: "adding the two numbers"
        def answer = calc.addAll(x, y, z, a, b, c, d, e, f, g)

        then: "the numbers are magically added!!"
        answer == expectedAnswer

        where:
        x << [1, 2, 3]
        y << [1, 2, 3]
        z << [1, 2, 3]
        a << [1, 2, 3]
        b << [1, 2, 3]
        c << [1, 2, 3]
        d << [1, 2, 3]
        e << [1, 2, 3]
        f << [1, 2, 3]
        g << [1, 2, 3]
        expectedAnswer << [10, 20, 30]
    }

}
