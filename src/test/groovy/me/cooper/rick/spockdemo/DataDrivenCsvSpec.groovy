package me.cooper.rick.spockdemo

import spock.lang.Specification
import spock.lang.Unroll


class DataDrivenCsvSpec extends Specification {

    def calc = new CrapCalc()

    @Unroll
    def 'csv works as a datasource #x + #y = #expectedAnswer'() {
        when: 'adding x and y'
        def answer = calc.add(x, y)

        then: 'the answer should be as expected'
        answer == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        [x, y, expectedAnswer] << csv()
    }

    def csv() {
        getClass().classLoader.getResourceAsStream('test-data.csv').text
                .split('\n')
                .drop(1)
                .collect { it.split(',').collect { it.toInteger() } }
    }
}