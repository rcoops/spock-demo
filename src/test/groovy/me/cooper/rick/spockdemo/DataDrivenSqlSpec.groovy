package me.cooper.rick.spockdemo


import me.cooper.rick.spockdemo.helper.SqlHelper
import spock.lang.Specification
import spock.lang.Unroll

import static me.cooper.rick.spockdemo.helper.SqlHelper.clearTestData
import static me.cooper.rick.spockdemo.helper.SqlHelper.populateTestData

class DataDrivenSqlSpec extends Specification {

//    @Shared def sql = Sql.newInstance "jdbc:h2:mem:test", "org.h2.Driver"

    def setupSpec() {
        populateTestData()
    }

    def cleanupSpec() {
        clearTestData()
    }

    @Unroll
    def '#expectedName is #expectedJobTitle'() {
        expect:
        name == expectedName
        jobTitle == expectedJobTitle

        where:
        [name, _, jobTitle] << SqlHelper.testData

        expectedName << ['Rick C', 'Daniel G']
        expectedJobTitle << ['Awesome', 'The Worst']
    }

    @Unroll
    def '#expectedName is #expectedJobTitle 2'() {
        expect:
        name == expectedName
        jobTitle == expectedJobTitle

        where:
        row << SqlHelper.testData
        name = row.name
        jobTitle = row.job_title
        expectedName << ['Rick C', 'Daniel G']
        expectedJobTitle << ['Awesome', 'The Worst']
    }
}