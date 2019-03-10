package me.cooper.rick.spockdemo.helper

class CsvHelper {

    static def getTestData() {
        CsvHelper.class.classLoader.getResourceAsStream('test-data.csv').text
                .split('\n')
                .drop(1) // Headers
                .collect { it.split(',').collect { it.toInteger() } }
    }
}
