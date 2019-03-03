package me.cooper.rick.spockdemo

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenSqlSpec extends Specification {

    @Shared def sql = Sql.newInstance "jdbc:h2:mem:test", "org.h2.Driver"

    def setupSpec() {
        sql.execute 'create table test(name varchar(50) primary key, team varchar(50), job_title varchar(100))'
        sql.executeInsert "insert into test(name, team, job_title) values ('Rick C', 'Power Arrangers', 'Awesome')"
        sql.executeInsert "insert into test(name, team, job_title) values ('Daniel G', 'UpScience', 'The Worst')"
    }

    def cleanupSpec() {
        sql.execute 'drop table test'
    }

    @Unroll
    def '#expectedName is #expectedJobTitle'() {
        expect:
        name == expectedName
        jobTitle == expectedJobTitle

        where:
        [name, _, jobTitle] << sql.rows('select * from test')

        expectedName << ['Rick C', 'Daniel G']
        expectedJobTitle << ['Awesome', 'The Worst']
    }

    @Unroll
    def '#expectedName is #expectedJobTitle 2'() {
        expect:
        name == expectedName
        jobTitle == expectedJobTitle

        where:
        row << sql.rows('select * from test')
        name = row.name
        jobTitle = row.job_title
        expectedName << ['Rick C', 'Daniel G']
        expectedJobTitle << ['Awesome', 'The Worst']
    }
}