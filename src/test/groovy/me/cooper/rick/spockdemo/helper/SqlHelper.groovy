package me.cooper.rick.spockdemo.helper

import groovy.sql.Sql

class SqlHelper {

    private static def sql = Sql.newInstance "jdbc:h2:mem:test", "org.h2.Driver"

    static def populateTestData() {
        sql.execute 'create table test(name varchar(50) primary key, team varchar(50), job_title varchar(100))'
        sql.executeInsert "insert into test(name, team, job_title) values ('Rick C', 'Power Arrangers', 'Awesome')"
        sql.executeInsert "insert into test(name, team, job_title) values ('Daniel G', 'UpScience', 'The Worst')"
        void
    }

    static def clearTestData() {
        sql.execute 'drop table test'
        void
    }

    static def getTestData() {
        sql.rows 'select * from test'
    }
}
