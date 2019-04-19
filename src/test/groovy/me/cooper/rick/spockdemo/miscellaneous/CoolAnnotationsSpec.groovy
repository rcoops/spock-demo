package me.cooper.rick.spockdemo.miscellaneous

import spock.lang.IgnoreIf
import spock.lang.PendingFeature
import spock.lang.Requires
import spock.lang.Specification
import spock.util.environment.OperatingSystem

import static me.cooper.rick.spockdemo.Fixtures.calc
import static spock.util.environment.OperatingSystem.Family.MAC_OS

class CoolAnnotationsSpec extends Specification {

    @PendingFeature
    def 'not yet implemented arrrgh!!'() {
        when: 'cubing 2'
        def result = calc.cube(2)

        then: 'the result is 8'
        result == 8
    }

    @Requires({ os.linux })
    def 'requires linux'() {
        when: 'getting the os name'
        def os = System.getProperty("os.name")

        then: "it's linux - shocking"
        'linux' == os.toLowerCase()
    }

    @IgnoreIf({ os.macOs })
    def 'macs be gone!!'() {
        given: 'all OSes except mac'
        def oses = OperatingSystem.Family.values().findAll { it != MAC_OS }.collect { it.name().toLowerCase() }

        when: 'getting the os name'
        def os = System.getProperty("os.name")

        then: 'the result is one of these'
        oses.contains(os.toLowerCase())
    }
}
