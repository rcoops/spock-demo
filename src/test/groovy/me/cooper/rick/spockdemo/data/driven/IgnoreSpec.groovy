package me.cooper.rick.spockdemo.data.driven

import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

class IgnoreSpec extends Specification {

    def "test true #1"() {
        expect:
        true
    }

    def "test true #2"() {
        expect:
        false
    }

    @Ignore("unless you want to fail")
    def "test true #3"() {
        expect:
        false
    }

    def "test true #4"() {
        expect:
        false
    }

    def "test true #5"() {
        expect:
        false
    }

    @IgnoreRest
    def "test true #6"() {
        expect:
        true
    }

    def "test true #7"() {
        expect:
        false
    }

    def "test true #8"() {
        expect:
        true
    }

    def "test true #9"() {
        expect:
        true
    }
}