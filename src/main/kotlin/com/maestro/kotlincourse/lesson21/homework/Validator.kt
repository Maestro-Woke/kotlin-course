package com.maestro.com.maestro.kotlincourse.lesson21.homework

interface Validator<T> {
    fun validate(value: T): Boolean
}