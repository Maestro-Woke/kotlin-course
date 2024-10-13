package com.maestro.com.maestro.kotlincourse.lesson12


fun main() {

    // Задание 6: Это для последнего задания, которое внизу
    drawRectangle(9, 8)

    // Сигнатуры функций

    // 1. Функция, которая не принимает аргументов и не возвращает значения
    fun doNothing(): Unit {}

    // 2. Функция, которая принимает два целых числа и возвращает их сумму
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    // 3. Функция, которая принимает строку и ничего не возвращает
    fun printString(text: String): Unit {
        println(text)
    }

    // 4. Функция, которая принимает список целых чисел и возвращает среднее значение типа Double
    fun calculateAverage(numbers: List<Int>): Double {
        return if (numbers.isNotEmpty()) numbers.average() else 0.0
    }

    // 5. Функция, которая принимает nullable строку и возвращает её длину в виде nullable целого числа
    fun getStringLength(text: String?): Int? {
        return text?.length
    }

    // 6. Функция, которая не принимает аргументов и возвращает nullable вещественное число
    fun getNullableDouble(): Double? {
        return null
    }

    // 7. Функция, которая принимает nullable список целых чисел и не возвращает значения
    fun processNullableList(numbers: List<Int?>?): Unit {
        numbers?.forEach { println(it) }
    }

    // 8. Функция, которая принимает целое число и возвращает nullable строку
    fun convertToNullableString(number: Int): String? {
        return if (number > 0) number.toString() else null
    }

    // 9. Функция, которая не принимает аргументов и возвращает список nullable строк
    fun getNullableStringList(): List<String?> {
        return listOf("Hello", null, "Kotlin")
    }

    // 10. Функция, которая принимает nullable строку и nullable целое число и возвращает nullable булево значение
    fun checkNullableValues(text: String?, number: Int?): Boolean? {
        return text?.isNotEmpty() == true && number != null
    }

    // Рабочий код для задач

    // Задача 1: multiplyByTwo
    fun multiplyByTwo(number: Int): Int {
        return number * 2
    }
    println("5 умножить на 2: ${multiplyByTwo(5)}")

    // Задача 2: isEven
    fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }
    println("Число 4 чётное: ${isEven(4)}")

    // Задача 3: printNumbersUntil
    fun printNumbersUntil(n: Int) {
        if (n < 1) return
        for (i in 1..n) {
            println(i)
        }
    }
    println("Числа от 1 до 5:")
    printNumbersUntil(5)

    // Задача 4: findFirstNegative
    fun findFirstNegative(numbers: List<Int>): Int? {
        for (number in numbers) {
            if (number < 0) {
                return number
            }
        }
        return null
    }
    val numbers = listOf(3, -1, 4, -2)
    println("Первое отрицательное число: ${findFirstNegative(numbers)}")

    // Задача 5: processList
    fun processList(strings: List<String?>) {
        for (str in strings) {
            if (str == null) return
            println(str)
        }
    }
    val stringList = listOf("Привет", "Мир", null, "Kotlin")
    println("Вывод строк из списка:")
    processList(stringList)
}

// Задание 6: Сделай рефакторинг функции, через определение вспомогательных приватных функций. Требуется избавиться от дублирования кода и трудно воспринимаемых фрагментов.
fun drawRectangle(width: Int, height: Int) {
    if (width <= 0) throw IllegalArgumentException("width должно быть положительным и больше нуля")
    if (height <= 0) throw IllegalArgumentException("height должно быть положительным и больше нуля")

    fun borderLine() = "+" + "-".repeat(width - 2) + "+"

    fun contentLine() = "|" + " ".repeat(width - 2) + "|"

    println(borderLine())

    repeat(height - 2) {
        println(contentLine())
    }

    println(borderLine())
}
