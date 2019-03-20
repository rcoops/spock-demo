package me.cooper.rick.spockdemo.introduction

import spock.lang.Specification

@SuppressWarnings("all")
class ButAreConditionsEnoughSpec extends Specification {

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

    def 'empty collection is false'() {
        expect:
        ![]
    }

    def 'empty string is false'() {
        expect:
        !""
    }
}
