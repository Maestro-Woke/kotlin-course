package com.maestro.com.maestro.kotlincourse.lesson21.homework

class StringValidator : Validator<String?> {
    override fun validate(value: String?): Boolean {
        return value != null && value.isNotBlank()
    }
}