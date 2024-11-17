package com.maestro.com.maestro.kotlincourse.lesson22.homework

fun <T> MutableList<T>.addToList(element: T) {
    this.add(element)
    println("Добавили $element! Вот твой новый список: $this")
}