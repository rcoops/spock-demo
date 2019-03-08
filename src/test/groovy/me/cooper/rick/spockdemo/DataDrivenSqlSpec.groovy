package me.cooper.rick.spockdemo

import groovy.sql.Sql
import me.cooper.rick.spockdemo.helper.SqlHelper
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static me.cooper.rick.spockdemo.helper.SqlHelper.clearTestData
import static me.cooper.rick.spockdemo.helper.SqlHelper.populateTestData

class DataDrivenSqlSpec extends Specification {

//    @Shared def sql = Sql.newInstance "jdbc:h2:mem:test", "org.h2.Driver"

    def setupSpec() {
        populateTestData()
//        sql.execute 'create table test(name varchar(50) primary key, team varchar(50), job_title varchar(100))'
//        sql.executeInsert "insert into test(name, team, job_title) values ('Rick C', 'Power Arrangers', 'Awesome')"
//        sql.executeInsert "insert into test(name, team, job_title) values ('Daniel G', 'UpScience', 'The Worst')"
    }

    def cleanupSpec() {
        clearTestData()
//        sql.execute 'drop table test'
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