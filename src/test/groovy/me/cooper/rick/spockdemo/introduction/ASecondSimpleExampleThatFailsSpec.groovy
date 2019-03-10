package me.cooper.rick.spockdemo.introduction

import spock.lang.Ignore
import spock.lang.Specification

import static me.cooper.rick.spockdemo.Fixtures.calc

@Ignore("unless you want to fail")
class ASecondSimpleExampleThatFailsSpec extends Specification {

    def "this test has no idea what it's talking about and so will fail"() {
        expect: 'adding 1 and 2 makes ...4?!!'
        calc.add(1, 2) == 4
    }

    def 'checking string equality'() {
        given: 'some almost identical strings'
        def one = 'I want to compare this string to another string'
        def two = 'I want to compare this string too another string'

        expect: 'they equal! Or do they...?'
        one == two
    }
}
