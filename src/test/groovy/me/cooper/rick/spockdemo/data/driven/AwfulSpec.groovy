package me.cooper.rick.spockdemo.data.driven

import spock.lang.Specification

import static me.cooper.rick.spockdemo.Fixtures.calc

class AwfulSpec extends Specification {

    def "I actually think I want to test more than just two numbers as I don't trust '+'"() {
        when: 'adding x and y'
        def answer = calc.add x, y

        then: 'the answer should be as expected'
        answer == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        x << [1, 2, 3]
        y << [1, 2, 3]
        expectedAnswer << [2, 4, 6]
    }

    def 'I care more about minimum lines than readability'() {
        when: 'adding x and y'
        def answer = calc.add x, y

        then: 'the answer should be as expected'
        answer == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        [x, y, expectedAnswer] << [[1, 1, 2], [2, 2, 4], [3, 3, 6]]
    }

    def "Let's test the really really advanced addAll logic now"() {
        when: 'adding all the numbers'
        def answer = calc.addAll x, y, z, a, b, c, d, e, f, g

        then: 'the numbers are magically added!!'
        answer == expectedAnswer

        //@formatter:off
        where:
        x              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        y              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        z              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        a              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        b              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        c              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        d              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        e              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        f              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        g              << [1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
        expectedAnswer << [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
        //@formatter:on
    }
}
