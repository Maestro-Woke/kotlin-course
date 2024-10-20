package com.maestro.com.maestro.kotlincourse.lesson13

fun main() {
    // Примеры коллекций
    val numbers = listOf(7, 18, 27, 34, 45, 52, 77)
    val textList = listOf("skin", "ear", "hand", null, "lung", null, "nerve")

    // Задачи на приведение коллекций к значению
    println("1. Размер коллекции больше 5 элементов: ${numbers.size > 5}")
    println("2. Коллекция пустая: ${numbers.isEmpty()}")
    println("3. Коллекция не пустая: ${numbers.isNotEmpty()}")
    println("4. Элемент по индексу или значение по умолчанию: ${numbers.getOrElse(10) { -1 }}")
    println("5. Коллекция в строку: ${numbers.joinToString(separator = ", ")}")
    println("6. Сумма всех значений: ${numbers.sum()}")
    println("7. Среднее значение: ${numbers.average()}")
    println("8. Максимальное число: ${numbers.maxOrNull()}")
    println("9. Минимальное число: ${numbers.minOrNull()}")
    println("10. Первое число или null: ${numbers.firstOrNull()}")
    println("11. Коллекция содержит элемент 30: ${numbers.contains(30)}")

    // Задачи на обработку коллекций
    val filteredRange = numbers.filter { it in 18..30 }
    println("1. Отфильтровано по диапазону 18-30: $filteredRange")

    val notDivisibleBy2And3 = numbers.filter { it % 2 != 0 || it % 3 != 0 }
    println("2. Числа, не делящиеся на 2 и 3 одновременно: $notDivisibleBy2And3")

    val cleanedTextList = textList.filterNotNull()
    println("3. Коллекция без null: $cleanedTextList")

    val wordLengths = cleanedTextList.map { it.length }
    println("4. Коллекция длин слов: $wordLengths")

    val reversedMap = cleanedTextList.associate { it to it.reversed() }
    println("5. Коллекция в мапу (слово -> перевёрнутое слово): $reversedMap")

    val sortedList = cleanedTextList.sorted()
    println("6. Отсортированный список в алфавитном порядке: $sortedList")

    val sortedDescendingList = cleanedTextList.sortedDescending()
    println("7. Отсортированный список по убыванию: $sortedDescendingList")

    println("8. Квадраты элементов списка:")
    numbers.forEach { println(it * it) }

    val groupedByFirstLetter = cleanedTextList.groupBy { it.first() }
    println("9. Группировка по первой букве: $groupedByFirstLetter")

    val distinctList = numbers.distinct()
    println("10. Список без дублей: $distinctList")

    val firstThreeElements = numbers.take(3)
    println("11. Первые 3 элемента: $firstThreeElements")

    val lastThreeElements = numbers.takeLast(3)
    println("12. Последние 3 элемента: $lastThreeElements")

    // Задание 2: Характеристика числовой коллекции
    fun describeCollection(collection1: List<Int>): String {
        return when {
            collection1.isEmpty() -> "Пусто"
            collection1.size < 5 -> "Короткая"
            collection1.firstOrNull() == 0 -> "Стартовая"
            collection1.sum() > 10000 -> "Массивная"
            collection1.average() == 10.0 -> "Сбалансированная"
            collection1.joinToString("").length == 20 -> "Клейкая"
            collection1.maxOrNull() ?: Int.MIN_VALUE < -10 -> "Отрицательная"
            collection1.minOrNull() ?: Int.MAX_VALUE > 1000 -> "Положительная"
            collection1.containsAll(listOf(3, 14)) -> "Пи***тая"
            else -> "Уникальная"
        }
    }

    // Тестирование метода describeCollection с разными входными данными
    println("1. ${describeCollection(emptyList())}") // Пусто
    println("2. ${describeCollection(listOf(1, 2, 3))}") // Короткая
    println("3. ${describeCollection(listOf(0, 10, 20))}") // Стартовая
    println("4. ${describeCollection(listOf(10000, 1))}") // Массивная
    println("5. ${describeCollection(listOf(10, 10, 10))}") // Сбалансированная
    println("6. ${describeCollection(listOf(1, 2, 3, 4, 56789))}") // Клейкая
    println("7. ${describeCollection(listOf(-20, -30))}") // Отрицательная
    println("8. ${describeCollection(listOf(1001, 2000, 3000))}") // Положительная
    println("9. ${describeCollection(listOf(3, 14))}") // Пи***тая
    println("10. ${describeCollection(listOf(5, 15, 25))}") // Уникальная

    // Задание 3: Анализ учебных оценок
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    val satisfactoryGrades = grades.filter { it >= 60 }.sorted().take(3)
    println("Сортированные удовлетворительные оценки (первые 3): $satisfactoryGrades")

    // Задание 4: Создание каталога по первой букве
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра",
        "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка",
        "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка",
        "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус",
        "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка",
        "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья",
        "посуда", "Настольная лампа", "торшер", "Этажерка"
    )
    val catalog = list.map { it.lowercase() }.groupBy { it.first() }
    println("Каталог по первой букве: $catalog")

    // Задание 5: Подсчёт средней длины слов в списке
    val averageWordLength = list.map { it.length }.average()
    println("Средняя длина слов: %.2f".format(averageWordLength))

    // Задание 6: Категоризация чисел
    val numberList = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    val categorizedNumbers = numberList.distinct().sortedDescending().groupBy { if (it % 2 == 0) "четные" else "нечетные" }
    println("Категоризация чисел: $categorizedNumbers")

    // Задание 7: Поиск первого подходящего элемента
    val ages = listOf(22, 18, 30, 45, 17, null, 60)
    val firstSuitableAge = ages.filterNotNull().firstOrNull { it > 18 }?.toString() ?: "Подходящий возраст не найден"
    println("Первый подходящий возраст: $firstSuitableAge")
}


