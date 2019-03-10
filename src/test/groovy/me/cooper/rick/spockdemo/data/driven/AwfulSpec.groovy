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
}