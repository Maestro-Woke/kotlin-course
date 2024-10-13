package com.maestro.com.maestro.kotlincourse.lesson11

fun main() {
    // Задание 1: Создание Пустого Словаря
    val emptyMap: Map<Int, Int> = mapOf()
    println("Пустой Словарь: $emptyMap")

    // Задание 2: Создание и Инициализация Словаря
    val initializedMap: Map<Float, Double> = mapOf(1.1f to 2.2, 3.3f to 4.4, 5.5f to 6.6)
    println("Инициализированный Словарь: $initializedMap")

    // Задание 3: Создание Изменяемого Словаря
    val mutableMap: MutableMap<Int, String> = mutableMapOf()
    println("Пустой Изменяемый Словарь: $mutableMap")

    // Задание 4: Добавление Элементов в Словарь
    mutableMap[1] = "Первый"
    mutableMap[2] = "Второй"
    mutableMap[3] = "Третий"
    println("Изменяемый Словарь после добавления элементов: $mutableMap")

    // Задание 5: Получение Значений из Словаря
    val value = mutableMap[2]
    println("Значение для ключа 2: $value")
    val nonExistentValue = mutableMap[10] ?: "Ключ не найден"
    println("Значение для несуществующего ключа: $nonExistentValue")

    // Задание 6: Удаление Элементов из Словаря
    mutableMap.remove(2)
    println("Изменяемый Словарь после удаления ключа 2: $mutableMap")

    // Задание 7: Перебор Словаря в Цикле
    val divisionMap: Map<Double, Int> = mapOf(6.0 to 2, 8.0 to 0, 3.0 to 3)
    for ((key, value) in divisionMap) {
        val result = if (value == 0) "бесконечность" else key / value
        println("$key / $value = $result")
    }

    // Задание 8: Перезапись Элементов Словаря
    mutableMap[3] = "Изменённый Третий"
    println("Изменяемый Словарь после обновления ключа 3: $mutableMap")

    // Задание 9: Сложение Двух Словарей
    val map1: Map<Int, String> = mapOf(4 to "Четвёртый", 5 to "Пятый")
    val map2: Map<Int, String> = mapOf(6 to "Шестой", 7 to "Седьмой")
    val combinedMap: MutableMap<Int, String> = mutableMapOf()
    combinedMap.putAll(map1)
    combinedMap.putAll(map2)
    println("Объединённый Словарь: $combinedMap")

    // Задание 10: Словарь с Сложными Типами
    val complexMap: MutableMap<String, List<Int>> = mutableMapOf()
    complexMap["Числа"] = listOf(1, 2, 3, 4)
    complexMap["Больше Чисел"] = listOf(10, 20, 30)
    println("Сложный Словарь: $complexMap")

    // Задание 11: Использование Множества в Качестве Значения
    val setMap: MutableMap<Int, MutableSet<String>> = mutableMapOf(1 to mutableSetOf("Один", "Два"))
    setMap[1]?.add("Три")
    println("Множество для ключа 1 после добавления 'Три': ${setMap[1]}")

    // Задание 12: Поиск Элемента по Значению
    val pairMap: Map<Pair<Int, Int>, String> = mapOf((5 to 6) to "Пара 5 и 6", (3 to 4) to "Пара 3 и 4")
    for ((key, value) in pairMap) {
        if (key.first == 5 || key.second == 5) {
            println("Найдено значение: $value для ключа: $key")
        }
    }

    // Дополнительные задачи:
    // Задание 6: Словарь Библиотека
    val library: MutableMap<String, MutableList<String>> = mutableMapOf(
        "Джордж Оруэлл" to mutableListOf("1984", "Скотный двор"),
        "Михаил Булгаков" to mutableListOf("Мастер и Маргарита", "Собачье сердце"),
        "Федор Достоевский" to mutableListOf("Преступление и наказание", "Идиот")

    )


    // Задание 12: Справочник Растений
    val plantDirectory: MutableMap<String, MutableList<String>> = mutableMapOf(
        "Цветы" to mutableListOf("Роза", "Тюльпан", "Орхидея"),
        "Деревья" to mutableListOf("Дуб", "Береза", "Сосна"),
        "Кустарники" to mutableListOf("Сирень", "Жасмин", "Барбарис")
    )

    // Задание 8: Четвертьфинала
    val quarterFinalTeams: MutableMap<String, MutableList<String>> = mutableMapOf(
        "Команда А" to mutableListOf("Игрок 1", "Игрок 2", "Игрок 3"),
        "Команда B" to mutableListOf("Игрок 4", "Игрок 5", "Игрок 6"),
        "Команда C" to mutableListOf("Игрок 7", "Игрок 8", "Игрок 10")
    )

    // Задание 9: Курс лечения
    val treatmentCourse: MutableMap<String, MutableList<String>> = mutableMapOf(
        "2024-10-01" to mutableListOf("Препарат A", "Препарат B"),
        "2024-10-02" to mutableListOf("Препарат C"),
        "2024-10-03" to mutableListOf("Препарат D", "Препарат E", "Препарат F")
    )

    // Задание 10: Словарь Путешественника
    val travelerDictionary: MutableMap<String, MutableMap<String, MutableList<String>>> = mutableMapOf(
        "Франция" to mutableMapOf(
            "Париж" to mutableListOf("Эйфелева башня", "Лувр"),
            "Марсель" to mutableListOf("Старый порт", "Базилика Нотр-Дам-де-ла-Гард")
        ),
        "Италия" to mutableMapOf(
            "Рим" to mutableListOf("Колизей", "Фонтан Треви"),
            "Венеция" to mutableListOf("Площадь Сан-Марко", "Большой канал")
        )
    )
}
