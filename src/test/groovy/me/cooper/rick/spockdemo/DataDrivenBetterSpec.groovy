package me.cooper.rick.spockdemo


import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenBetterSpec extends Specification {

    def calc = new CrapCalc()

    def "Let's test the really really advanced addAll logic now"() {
        given: "nothing... given nothing"

        when: "adding all the numbers"
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
        expectedAnswer << [10, 40, 30]
    }

    // fail this test to lead on to Unroll
    def 'this is better'() {
        when: 'adding x and y'
        def answer = calc.addAll(x, y, z, a, b, c, d, e, f, g)

        then: 'the answer should be as expected'
        answer == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        x | y | z | a | b | c | d | e | f | g || expectedAnswer
        1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 || 10
        2 | 2 | 2 | 2 | 2 | 2 | 2 | 2 | 2 | 2 || 20
        3 | 3 | 3 | 3 | 3 | 3 | 3 | 3 | 3 | 3 || 30
    }

    // fail this test to lead on to Unroll
    def 'this is DEFINITELY better for lots of test cases'() {
        when: 'adding x and y'
        def answer = calc.addAll(x, y, z, a, b, c, d, e, f, g)

        then: 'the answer should be as expected'
        answer == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        x | y | z | a | b | c | d | e | f | g || expectedAnswer
        1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 || 10
        2 | 2 | 2 | 2 | 2 | 2 | 2 | 2 | 2 | 2 || 20
        3 | 3 | 3 | 3 | 3 | 3 | 3 | 3 | 3 | 3 || 30
    }

    @Unroll
    def 'this is even better! #x + #y + #a + #b + #c + #c + #d + #e + #f + #g = #expectedAnswer'() {
        when: 'adding x and y'
        def answer = calc.addAll(x, y, z, a, b, c, d, e, f, g)

        then: 'the answer should be as expected'
        answer == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        x | y | z | a | b | c | d | e | f | g || expectedAnswer
        1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 || 10
        2 | 2 | 2 | 2 | 2 | 2 | 2 | 2 | 2 | 2 || 20
        3 | 3 | 3 | 3 | 3 | 3 | 3 | 3 | 3 | 3 || 30
    }

}
