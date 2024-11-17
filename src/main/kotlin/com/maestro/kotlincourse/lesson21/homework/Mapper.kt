package com.maestro.com.maestro.kotlincourse.lesson21.homework

interface Mapper<T, R> {
    fun transform(element: T): R
    fun transformList(elements: List<T>): List<R>
}