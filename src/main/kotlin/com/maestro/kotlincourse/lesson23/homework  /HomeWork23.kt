package com.maestro.com.maestro.kotlincourse.lesson23.`homework  `


// Задача 1
fun analyzeDataType(data: Any) {
    when (data) {
        is String -> println("Эй, это строка с секретом: \"$data\"")
        is Int -> println("Ого, это целое число: $data. Оно прямоугольное, но в воображении.")
        is List<*> -> println("А вот это — список сокровищ, их аж: ${data.size} штуки!")
        is Map<*, *> -> println("Ух ты, это карта приключений! Пару аж: ${data.size}.")
        else -> println("Загадка века: это что-то неизвестное, как пришелец.")
    }
}


// Задача 2
fun safeCastToList(possibleList: Any): Int {
    val treasureChest = possibleList as? List<*>
    return treasureChest?.size ?: -1.also {
        println("Опа! Это не сундук со списком!")
    }
}


// Задача 3
fun getStringLengthOrZero(possibleString: Any?): Int {
    return (possibleString as? String)?.length ?: 0.also {
        println("Ну вот, это не строка, а загадка пустоты!")
    }
}


// Задача 4
fun squareNumberOrString(magicNumber: Any): Double {
    return when (magicNumber) {
        is Number -> {
            println("Число пришло, квадратим!")
            magicNumber.toDouble() * magicNumber.toDouble()
        }
        is String -> {
            println("О! Это строка с числом, превращаем в квадрат.")
            val parsedNumber = magicNumber.toDoubleOrNull()
            if (parsedNumber != null) {
                parsedNumber * parsedNumber
            } else {
                println("Но-но-но! Это строка неправильная!")
                0.0
            }
        }
        else -> {
            println("Какой ужас! Мы этого не умеем!")
            0.0
        }
    }
}

// Задача 5
fun sumIntOrDoubleValues(data: List<Any>): Double {
    return data
        .filter { it is Int || it is Double }
        .sumOf {
            if (it is Int) it.toDouble() else (it as Double)
        }
}

// Задача 6
fun tryCastToListAndPrint(data: Any) {
    val list = data as? List<*>
    if (list != null) {
        list.forEach { println(it ?: "Не строка!") }
    } else {
        println("Это не список")
    }
}

fun main() {
    // Задача 1
    analyzeDataType("Пример")
    analyzeDataType(123)
    analyzeDataType(listOf(1, 2, 3))
    analyzeDataType(mapOf("ключ" to "значение"))
    analyzeDataType(3.14)

    // Задача 2
    println("Размер списка: ${safeCastToList(listOf(1, 2, 3))}")
    println("Размер списка: ${safeCastToList("Не список")}")

    // Задача 3
    println("Длина строки: ${getStringLengthOrZero("Привет!")}")
    println("Длина строки: ${getStringLengthOrZero(12345)}")

    // Задача 4
    println("Квадрат числа: ${squareNumberOrString(4)}")
    println("Квадрат строки: ${squareNumberOrString("4.2")}")
    println("Квадрат неизвестного: ${squareNumberOrString(true)}")

    // Задача 5
    val data = listOf(1, 2.5, "строка", 3, true)
    println(sumIntOrDoubleValues(data))

    // Задача 6
    tryCastToListAndPrint(listOf("Список"))
    tryCastToListAndPrint("не список")
}