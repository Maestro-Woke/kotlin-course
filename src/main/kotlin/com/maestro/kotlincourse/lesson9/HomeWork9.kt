package com.maestro.com.maestro.kotlincourse.lesson9

fun main() {
    val birthdayPerson = "Саша @webrelab"
    println(" Привет, $birthdayPerson! ")

    // Пожелания
    val wishes = arrayOf(
        "С днём рождения! Пусть в твоей жизни будет столько же радости, сколько строк в коде!",
        "Желаю, чтобы твоя жизнь была как идеальный проект — без багов и с хорошей документацией!",
        "С днём рождения! Пусть каждый билд твоей жизни будет успешным и без ошибок!"
    )

    val endings = arrayOf(
        "Помни, что каждый новый день — это новый pull request к жизни!",
        "Пусть каждый момент будет закоммичен в твою память с любовью!",
        "Счастья тебе, здоровья и много удачных проектов!",
    )

    // Генерация поздравления
    val finalWish = "${wishes.random()} ${endings.random()}"

    val acronym = createAcronym(finalWish)

    println("\n У меня есть для тебя загадка: ")
    val riddle = "Что идёт вверх, но не может спуститься?"
    println(" Загадка: $riddle")

    // Ответ на загадку
    val correctAnswer = "лестница"

    var attempts = 0
    var answeredCorrectly = false

    do {
        println("\n Напиши свой ответ:")
        val answer = readlnOrNull()?.trim()?.lowercase()

        attempts++
        if (answer == correctAnswer) {
            println(" Правильно! Молодец! ")
            answeredCorrectly = true
        } else {
            println(" Неправильно! Попробуй ещё раз.")
        }
    } while (!answeredCorrectly && attempts < 3)

    // Поздравление после успешного ответа
    if (answeredCorrectly) {
        println("\n Поздравление готово! 🎊")
        printWithDelay(finalWish)
        println(" Аббревиатура поздравления: $acronym")
    } else {
        println("\n К сожалению, ты не смог разгадать загадку. Но я всё равно желаю тебе счастья! ")
    }
}

// Функция для создания аббревиатуры
fun createAcronym(phrase: String): String {
    var acronym = ""
    val words = phrase.split(" ")
    for (word in words) {
        acronym += word.first().uppercaseChar()
    }
    return acronym
}

// Функция для вывода текста с эффектом печати
fun printWithDelay(text: String) {
    for (char in text) {
        print(char)
        Thread.sleep(50)
    }
    println()
}



