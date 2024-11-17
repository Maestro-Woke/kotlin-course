package com.maestro.com.maestro.kotlincourse.lesson21.homework

class ListHolder<T> {
    private val elements = mutableListOf<T>()

    fun addElement(element: T) {
        elements.add(element)
    }

    fun getAllElements(): List<T> = elements
}