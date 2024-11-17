package com.maestro.com.maestro.kotlincourse.lesson22.homework

fun String.encryptWithFun(base: Int): String {
    val result = this.map { (it + base).toChar() }.joinToString("")
    println("Я зашифровал твой секрет: $result")
    return result
}

fun String.decryptWithFun(base: Int): String {
    val result = this.map { (it - base).toChar() }.joinToString("")
    println("Я вернул твой секрет обратно: $result")
    return result
}