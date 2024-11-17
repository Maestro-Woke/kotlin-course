package com.maestro.com.maestro.kotlincourse.lesson22.homework

fun Long?.longToStringFun(): String {
    val result = this?.toString() ?: "Где твоё длинное число?"
    println("Вот оно: $result")
    return result
}