package me.cooper.rick.spockdemo

import spock.lang.Specification


class CSpec extends Specification {
    def "HashMap accepts null key"() {
        given:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }
}