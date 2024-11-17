package com.maestro.com.maestro.kotlincourse.lesson21.homework

class OddValidator : Validator<Int> {
    override fun validate(value: Int): Boolean {
        return value % 2 == 0
    }
}