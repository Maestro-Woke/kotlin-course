package com.maestro.com.maestro.kotlincourse.lesson22.homework

fun main() {

    println(" 1-2. a. Пара элементов массива")
    val sillyArray = arrayOf(7, 3, 1, 99)
    println("Пара: ${sillyArray.toSillyPair()}")

    println("\n 1-2. b. Шоу с символами")
    val sillyChar: Char? = '!'
    sillyChar.charComedy(42, 777, true)

    println("\n 1-2. c. Преобразование словаря")
    val animalSounds = mapOf("кот" to "мяу", "пёс" to "гав")
    println("Новый словарь: ${animalSounds.keysToWords()}")

    println("\n 1-2. d. Добавление элементов в список")
    val animals = mutableListOf("кот", "пёс", "мышь")
    animals.addToList("слон")
    println("Обновленный список: $animals")

    println("\n 1-2. e. Преобразование длинного числа")
    val bigNumber: Long? = 987654321L
    println("Результат: ${bigNumber.longToStringFun()}")

    val noNumber: Long? = null
    println("Результат: ${noNumber.longToStringFun()}")

    println("\n 3. Переворот элементов пары")
    val chaosPair = Pair("Кот", 42)
    println("Перевернутая пара: ${chaosPair.revertWithChaos()}")

    println("\n 4. Проверка допустимого отклонения числа")
    val number1 = 10
    val number2 = 12
    val deviation = 3
    println("Результат 1: ${number1.isCloseTo(number2, deviation)}") // true
    println("Результат 2: ${number1.isCloseTo(15, deviation)}")      // false

    println("\n 5. Кодер-декодер строк")
    val secret = "Woke"
    val coded = secret.encryptWithFun(5)
    val decoded = coded.decryptWithFun(5)
    println("Закодировано: $coded, Раскодировано: $decoded")

    println("\n 6. Собери пидмаркоз")
    val wordToPlay = "достопримечательность"
    val sillyPlayers = listOf("Боб", "Иони", "Бобик")
    wordToPlay.displayAsGame(sillyPlayers)
}