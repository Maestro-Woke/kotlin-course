package com.maestro.com.maestro.kotlincourse.lesson21.homework

class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun transform(element: String): List<String> {
        return element.split(" ")
    }

    override fun transformList(elements: List<String>): List<List<String>> {
        return elements.map { transform(it) }
    }
}