package me.cooper.rick.spockdemo

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


class DataDrivenCsvSpec extends Specification {

    def calc = new CrapCalc()

    @Shared
    def sql = Sql.newInstance "jdbc:h2:mem:test", "org.h2.Driver"

    @Unroll
    def 'csv works as a datasource #x + #y = #expectedAnswer'() {
        when: 'adding x and y'
        def answer = calc.add(x, y)

        then: 'the answer should be as expected'
        answer == expectedAnswer

        where: 'there are multiple complicated combinations of x and y'
        [x, y, expectedAnswer] << csv()
    }

    @Unroll
    def "rick c is awesome"() {
        expect:
        name == expectedName
        jobTitle == expectedJobTitle

        where:
        [name, _, jobTitle] << sql.rows('select * from test')

        expectedName << ['Rick C', 'Daniel G']
        expectedJobTitle << ['Awesome', 'The Worst']
    }

    // todo ( [a, b, _, c] << sql.rows("select * from maxdata")

    def csv() {
        getClass().classLoader.getResourceAsStream('test-data.csv').text
                .split('\n')
                .drop(1)
                .collect { it.split(',').collect { it.toInteger() } }
    }
}