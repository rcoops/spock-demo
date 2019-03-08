package me.cooper.rick.spockdemo

import me.cooper.rick.spockdemo.helper.CsvHelper
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenCsvSpec extends Specification {

    @Shared calc = new CrapCalc()

    @Unroll
    def 'csv works as a datasource #x + #y = #expectedAnswer'() {
        expect: 'the answer should be as expected'
        calc.add(x, y) == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        [x, y, expectedAnswer] << CsvHelper.testData
    }
}