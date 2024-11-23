package com.maestro.com.maestro.kotlincourse.lesson24.homework

import kotlin.math.pow

fun main() {
    // Задание 1: Фрагменты кода, вызывающие исключения
    try {
        // NullPointerException
        val maybeNull: String? = null
        maybeNull!!.length

        // ArrayIndexOutOfBoundsException
        val array = arrayOf(1, 2, 3)
        println(array[10])

        // ClassCastException
        val obj: Any = "Not an Integer"
        val number = obj as Int

        // NumberFormatException
        val invalidNumber = "123abc".toInt()

        // IllegalArgumentException
        val radius = -5
        require(radius > 0) { "Радиус должен быть положительным" }

        // IllegalStateException
        val state = "idle"
        check(state == "running") { "Состояние должно быть 'running'" }

        // OutOfMemoryError
        val hugeArray = IntArray(Int.MAX_VALUE)

        // StackOverflowError
        fun recurse(): Int = recurse()
        recurse()
    } catch (e: NullPointerException) {
        println("Ошибка: NullPointerException - Попытка доступа к null-объекту")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Ошибка: ArrayIndexOutOfBoundsException - Индекс за пределами массива")
    } catch (e: ClassCastException) {
        println("Ошибка: ClassCastException - Некорректное приведение типа")
    } catch (e: NumberFormatException) {
        println("Ошибка: NumberFormatException - Невозможно преобразовать строку в число")
    } catch (e: IllegalArgumentException) {
        println("Ошибка: IllegalArgumentException - Неправильный аргумент")
    } catch (e: IllegalStateException) {
        println("Ошибка: IllegalStateException - Нарушение состояния объекта")
    } catch (e: OutOfMemoryError) {
        println("Ошибка: OutOfMemoryError - Недостаточно памяти для выполнения операции")
    } catch (e: StackOverflowError) {
        println("Ошибка: StackOverflowError - Переполнение стека из-за рекурсии")
    }

    // Задание 2: Один общий блок catch с обработкой через when
    try {
        val invalidNumber = "12abc".toInt()
    } catch (e: Throwable) {
        when (e) {
            is NullPointerException -> println("Ошибка NullPointerException - Доступ к null")
            is ArrayIndexOutOfBoundsException -> println("Ошибка ArrayIndexOutOfBoundsException - Индекс вне массива")
            is ClassCastException -> println("Ошибка ClassCastException - Неправильный тип")
            is NumberFormatException -> println("Ошибка NumberFormatException - Невозможно конвертировать строку")
            is IllegalArgumentException -> println("Ошибка IllegalArgumentException - Некорректный аргумент")
            is IllegalStateException -> println("Ошибка IllegalStateException - Состояние объекта неверное")
            is OutOfMemoryError -> println("Ошибка OutOfMemoryError - Память переполнена")
            is StackOverflowError -> println("Ошибка StackOverflowError - Стек вызовов переполнен")
            else -> println("Неизвестная ошибка: ${e.message}")
        }
    }

    // Задание 4: Создание исключения AssertionException
    throw MyAssertionException("Это пользовательское исключение типа AssertionError!")

    // Задание 5: Исключение с передачей другого типа исключения
    try {
        val array = arrayOf(1, 2, 3)
        println(array[10]) // Ошибка ArrayIndexOutOfBoundsException
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Ошибка: ${e.message} - Индекс вне массива")
        throw MyRuntimeException(e)
    }
}

// Задание 4: Создание пользовательского исключения
class MyAssertionException(message: String) : AssertionError(message)

// Задание 5: Создание исключения, принимающего другой тип
class MyRuntimeException(cause: Throwable) : RuntimeException("Кастомное исключение из-за ошибки: ${cause.message}", cause)