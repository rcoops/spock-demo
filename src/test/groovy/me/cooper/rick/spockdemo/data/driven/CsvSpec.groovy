package me.cooper.rick.spockdemo.data.driven

import me.cooper.rick.spockdemo.helper.CsvHelper
import spock.lang.Specification
import spock.lang.Unroll

import static me.cooper.rick.spockdemo.Fixtures.calc

class CsvSpec extends Specification {

    @Unroll
    def 'csv works as a datasource #x + #y = #expectedAnswer'() {
        expect: 'the answer should be as expected'
        calc.addAll(x, y, z, a, b, c, d, e, f, g) == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        [x, y, z, a, b, c, d, e, f, g, expectedAnswer] << CsvHelper.testData
    }
}