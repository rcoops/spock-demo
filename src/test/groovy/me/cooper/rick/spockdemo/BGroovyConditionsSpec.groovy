package me.cooper.rick.spockdemo

import spock.lang.Specification


class BGroovyConditionsSpec extends Specification {

    def 'well duh'() {
        expect:
        !false
    }

    def 'nothing is false!'() {
        expect:
        !null
    }

    def '0 is false'() {
        expect:
        !0
    }

    def 'empty list is false'() {
        expect:
        ![]
    }

    def 'empty string is false'() {
        expect:
        !""
    }

}