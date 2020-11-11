package me.cooper.rick.spockdemo.data.driven


import spock.lang.Specification
import spock.lang.Unroll

import static me.cooper.rick.spockdemo.Fixtures.calc

class BetterSpec extends Specification {

//    @Ignore('unless you want to fail')
    def 'this is DEFINITELY better for lots of test cases'() {
        when: 'adding x and y'
        def answer = calc.addAll x, y, z, a, b, c, d, e, f, g

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
        def answer = calc.addAll x, y, z, a, b, c, d, e, f, g

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
