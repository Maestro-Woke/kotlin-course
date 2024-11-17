package com.maestro.com.maestro.kotlincourse.lesson21.homework

fun <T> getMiddleElement(list: List<T>): T? {
    if (list.isEmpty()) return null
    return list[list.size / 2]
}