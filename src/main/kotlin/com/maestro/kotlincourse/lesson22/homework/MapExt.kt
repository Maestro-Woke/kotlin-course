package com.maestro.com.maestro.kotlincourse.lesson22.homework

fun <K, V> Map<K, V>.keysToWords(): List<String> {
    println("Превращаем ключи в слова!")
    return this.keys.map { "Вот ключ: $it" }.also { println("Получилось: $it") }
}