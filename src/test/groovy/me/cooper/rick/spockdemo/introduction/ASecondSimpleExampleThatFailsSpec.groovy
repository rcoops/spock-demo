package me.cooper.rick.spockdemo.introduction

import spock.lang.Ignore
import spock.lang.Specification

import static me.cooper.rick.spockdemo.Fixtures.calc

@Ignore('unless you want to fail')
class ASecondSimpleExampleThatFailsSpec extends Specification {

    def "this test has no idea what it's talking about and so will fail"() {
        expect: 'adding 1 and 1 makes ...3?!!'
        calc.add(1, 1) == 3
    }

    def 'checking string equality'() {
        given: 'some almost identical strings'
        def one = 'I want to compare this string to another string'
        def two = 'I want to compare this string too another string'

        expect: 'they equal! Or do they...?'
        one == two
    }

    def 'checking object equality'() {
        given: 'some things'
        def one = new Thing(1)
        def two = new Thing(2)

        expect: 'they equal! Or do they...?'
        one == two
    }
}

class Thing {
    def thing

    Thing(thing) {
        this.thing = thing
    }
}
