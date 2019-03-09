package me.cooper.rick.spockdemo

import spock.lang.Ignore
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

    @Ignore("until you want to fail")
    def 'this is DEFINITELY better for lots of test cases'() {
        when: 'adding x and y'
        def answer = calc.addAll(x, y, z, a, b, c, d, e, f, g)

        then: 'the answer should be as expected'
        answer == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        x  | y  | z  | a  | b  | c  | d  | e  | f  | g  || expectedAnswer
        1  | 1  | 1  | 1  | 1  | 1  | 1  | 1  | 1  | 1  || 10
        2  | 2  | 2  | 2  | 2  | 2  | 2  | 2  | 2  | 2  || 40
        3  | 3  | 3  | 3  | 3  | 3  | 3  | 3  | 3  | 3  || 30
        4  | 4  | 4  | 4  | 4  | 4  | 4  | 4  | 4  | 4  || 40
        5  | 5  | 5  | 5  | 5  | 5  | 5  | 5  | 5  | 5  || 50
        6  | 6  | 6  | 6  | 6  | 6  | 6  | 6  | 6  | 6  || 60
        7  | 7  | 7  | 7  | 7  | 7  | 7  | 7  | 7  | 7  || 70
        8  | 8  | 8  | 8  | 8  | 8  | 8  | 8  | 8  | 8  || 80
        9  | 9  | 9  | 9  | 9  | 9  | 9  | 9  | 9  | 9  || 90
        10 | 10 | 10 | 10 | 10 | 10 | 10 | 10 | 10 | 10 || 100
    }

    @Unroll
    def 'this is even better! #x + #y + #a + #b + #c + #c + #d + #e + #f + #g = #expectedAnswer'() {
        when: 'adding x and y'
        def answer = calc.addAll(x, y, z, a, b, c, d, e, f, g)

        then: 'the answer should be as expected'
        answer == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        x  | y  | z  | a  | b  | c  | d  | e  | f  | g  || expectedAnswer
        1  | 1  | 1  | 1  | 1  | 1  | 1  | 1  | 1  | 1  || 10
        2  | 2  | 2  | 2  | 2  | 2  | 2  | 2  | 2  | 2  || 20
        3  | 3  | 3  | 3  | 3  | 3  | 3  | 3  | 3  | 3  || 30
        4  | 4  | 4  | 4  | 4  | 4  | 4  | 4  | 4  | 4  || 40
        5  | 5  | 5  | 5  | 5  | 5  | 5  | 5  | 5  | 5  || 50
        6  | 6  | 6  | 6  | 6  | 6  | 6  | 6  | 6  | 6  || 60
        7  | 7  | 7  | 7  | 7  | 7  | 7  | 7  | 7  | 7  || 70
        8  | 8  | 8  | 8  | 8  | 8  | 8  | 8  | 8  | 8  || 80
        9  | 9  | 9  | 9  | 9  | 9  | 9  | 9  | 9  | 9  || 90
        10 | 10 | 10 | 10 | 10 | 10 | 10 | 10 | 10 | 10 || 100
    }

}
