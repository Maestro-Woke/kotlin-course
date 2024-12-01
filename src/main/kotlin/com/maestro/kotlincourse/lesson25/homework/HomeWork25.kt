package com.maestro.com.maestro.kotlincourse.lesson25.homework

fun main() {
    // Задание 1
    fun printConstant() = println(CONSTANT_TEXT)
    val anonymousPrintConstant = fun() = println(CONSTANT_TEXT)
    val lambdaPrintConstantWithType: () -> Unit = { println(CONSTANT_TEXT) }
    val lambdaPrintConstant = { println(CONSTANT_TEXT) }

    println("Задание 1:")
    printConstant()
    anonymousPrintConstant()
    lambdaPrintConstantWithType()
    lambdaPrintConstant()

    // Задание 2ц
    fun calculateAverage(numbers: List<Int>): Double {
        require(numbers.isNotEmpty()) { "Список не может быть пустым" }
        return numbers.average()
    }
    val lambdaCalculateAverage: (List<Int>) -> Double = { numbers ->
        require(numbers.isNotEmpty()) { "Список не может быть пустым" }
        numbers.average()
    }
    val lambdaCalculateAverageWithType: (List<Int>) -> Double = { numbers ->
        require(numbers.isNotEmpty()) { "Список не может быть пустым" }
        numbers.average()
    }
    val lambdaCalculateAverage2 = { numbers: List<Int> ->
        require(numbers.isNotEmpty()) { "Список не может быть пустым" }
        numbers.average()
    }

    println("\nЗадание 2:")
    println(calculateAverage(listOf(1, 2, 3, 4, 5)))
    println(lambdaCalculateAverage(listOf(1, 2, 3, 4, 5)))
    println(lambdaCalculateAverageWithType(listOf(1, 2, 3, 4, 5)))
    println(lambdaCalculateAverage2(listOf(1, 2, 3, 4, 5)))

    // Задание 3
    fun filterStringsByLength(strings: List<String>, minLength: Int): List<String> {
        require(strings.isNotEmpty()) { "Список строк не может быть пустым" }
        return strings.filter { it.length >= minLength }
    }
    val anonymousFilterStrings = fun(strings: List<String>, minLength: Int): List<String> {
        require(strings.isNotEmpty()) { "Список строк не может быть пустым" }
        return strings.filter { it.length >= minLength }
    }
    val lambdaFilterStringsWithType: (List<String>, Int) -> List<String> = { strings, minLength ->
        require(strings.isNotEmpty()) { "Список строк не может быть пустым" }
        strings.filter { it.length >= minLength }
    }
    val lambdaFilterStrings = { strings: List<String>, minLength: Int ->
        require(strings.isNotEmpty()) { "Список строк не может быть пустым" }
        strings.filter { it.length >= minLength }
    }

    println("\nЗадание 3:")
    println(filterStringsByLength(listOf("App", "Aaa", "CV"), 5))
    println(anonymousFilterStrings(listOf("App", "Aaa", "CV"), 5))
    println(lambdaFilterStringsWithType(listOf("App", "Aaa", "CV"), 5))
    println(lambdaFilterStrings(listOf("App", "Aaa", "CV"), 5))

    // Задание 4
    fun sumOfDigits(number: Int): Int = number.toString().sumOf { it.digitToInt() }
    val anonymousSumOfDigits = fun(number: Int): Int = number.toString().sumOf { it.digitToInt() }
    val lambdaSumOfDigitsWithType: (Int) -> Int = { number -> number.toString().sumOf { it.digitToInt() } }
    val lambdaSumOfDigits = { number: Int -> number.toString().sumOf { it.digitToInt() } }

    println("\nЗадание 4:")
    println(sumOfDigits(12345))
    println(anonymousSumOfDigits(12345))
    println(lambdaSumOfDigitsWithType(12345))
    println(lambdaSumOfDigits(12345))

    // Задание 5
    fun removeDuplicates(numbers: List<Int>): List<Int> = numbers.toSet().toList()
    val anonymousRemoveDuplicates = fun(numbers: List<Int>): List<Int> = numbers.toSet().toList()
    val lambdaRemoveDuplicatesWithType: (List<Int>) -> List<Int> = { numbers -> numbers.toSet().toList() }
    val lambdaRemoveDuplicates = { numbers: List<Int> -> numbers.toSet().toList() }

    println("\nЗадание 5:")
    println(removeDuplicates(listOf(1, 2, 2, 3, 4, 4, 5)))
    println(anonymousRemoveDuplicates(listOf(1, 2, 2, 3, 4, 4, 5)))
    println(lambdaRemoveDuplicatesWithType(listOf(1, 2, 2, 3, 4, 4, 5)))
    println(lambdaRemoveDuplicates(listOf(1, 2, 2, 3, 4, 4, 5)))

    // Задание 6
    fun Map<String, Int>.filterKeysByLength(minLength: Int): List<String> {
        return this.keys.filter { it.length > minLength && it.length < (this[it] ?: 0) }
            .ifEmpty { throw IllegalStateException("Список ключей пуст") }
    }

    println("\nЗадание 6:")
    val testMap = mapOf("Short" to 10, "LengthyKey" to 3, "Medium" to 5)
    println(testMap.filterKeysByLength(2))

    // Задание 7
    fun <T, U> Map<T, U>.printAndConcat(args: List<Any>): String {
        this.forEach { (key, value) -> println("Ключ: $key, Значение: $value") }
        args.forEach { println("Аргумент: $it") }
        return this.entries.joinToString(", ") { "${it.key}=${it.value}" } + args.joinToString("")
    }

    println("\nЗадание 7:")
    val combinedMap = mapOf("Key1" to 1, "Key2" to 2)
    println("Конкатенация: ${combinedMap.printAndConcat(listOf(1, "String", listOf(1, 2, 3)))}")
}