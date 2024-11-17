package com.maestro.com.maestro.kotlincourse.lesson21.homework

fun <K, V> toMap(keys: List<K>, values: List<V>): Map<K, V> {
    return keys.zip(values).toMap()
}