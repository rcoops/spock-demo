package me.cooper.rick.spockdemo.data.driven

import me.cooper.rick.spockdemo.helper.SqlHelper
import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenSqlSpec extends Specification {

    def setupSpec() {
        SqlHelper.populateTestData()
    }

    def cleanupSpec() {
        SqlHelper.clearTestData()
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