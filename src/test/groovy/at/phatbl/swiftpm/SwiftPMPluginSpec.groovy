package at.phatbl.swiftpm

import spock.lang.Specification

class SwiftPMPluginSpec extends Specification {
    def "when-then"() {
        when:
        def x = Math.max(1, 2)

        then:
        x == 2
    }

    def "expect"() {
        expect:
        Math.max(1, 2) == 2
    }

    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }
}
