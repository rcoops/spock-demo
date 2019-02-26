package me.cooper.rick.spockdemo

import spock.lang.Ignore
import spock.lang.Specification

class ZIgnoreSpec extends Specification {


    def "test true #1"() {
        when:
        true
        then:
        true
    }

    def "test true #2"() {
        when:
        true
        then:
        true
    }

    @Ignore
    def "test true #3"() {
        when:
        true
        then:
        true
    }

    def "test true #4"() {
        when:
        true
        then:
        true
    }

    def "test true #5"() {
        when:
        true
        then:
        true
    }

//    @IgnoreRest
    def "test true #6"() {
        when:
        true
        then:
        true
    }

    def "test true #7"() {
        when:
        true
        then:
        true
    }

    def "test true #8"() {
        when:
        true
        then:
        true
    }

    def "test true #9"() {
        when:
        true
        then:
        true
    }

}