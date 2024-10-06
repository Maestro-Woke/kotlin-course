package com.maestro.com.maestro.kotlincourse.lesson10


fun main() {
    /* Работа с массивами Array */

    // Задание 1: Создание и Инициализация Массива
    val array1 = arrayOf(1, 2, 3, 4, 5)

    // Задание 2: Создание Пустого Массива
    val array2 = arrayOfNulls<String>(10)

    // Задание 3: Заполнение Массива в Цикле
    val array3 = DoubleArray(5)
    for (i in array3.indices) {
        array3[i] = i * 2.0
    }

    // Задание 4: Изменение Элементов Массива
    val array4 = IntArray(5)
    for (b in array4.indices) {
        array4[b] = b * 3
    }

    // Задание 5: Работа с Nullable Элементами
    val array5 = arrayOf<String?>(null, "Hola", "Amigo")

    // Задание 6: Копирование Массива
    val array6 = intArrayOf(1, 2, 3, 4, 5)
    val copiedArray = IntArray(array6.size)
    for (v in array6.indices) {
        copiedArray[v] = array6[v]
    }

    // Задание 7: Разница Двух Массивов
    val array7_1 = intArrayOf(1, 2, 3, 4, 5)
    val array7_2 = intArrayOf(6, 7, 10, 22, 4)
    val array_final = IntArray(array7_1.size)
    for (c in array7_1.indices) {
        array_final[c] = array7_1[c] - array7_2[c]
    }

    // Задание 8: Поиск Индекса Элемента
    val array8 = intArrayOf(3, 4, 5, 6, 7)
    var index = -1
    var x = 0
    while (x < array8.size) {
        if (array8[x] == 5) {
            index = x
            break
        }
        x++
    }

    // Задание 9: Перебор Массива
    val array9 = intArrayOf(1, 2, 3, 4, 5)
    for (num in array9) {
        val evenOrOdd = if (num % 2 == 0) "чётное" else "нечётное"
        println("$num — $evenOrOdd")
    }

    // Задание 10: Поиск Значения в Массиве по вхождению
    fun findStringInArray(array: Array<String>, searchString: String): String? {
        for (element in array) {
            if (element.contains(searchString)) {
                return element
            }
        }
        return null
    }

    val lego = arrayOf("technica", "ninzago", "cherry")
    val found = findStringInArray(lego, "nin")
    println(found)


    /* Работа со списками List */

    // Задание 1: Создание Пустого Списка
    val emptyList: List<Int> = listOf()

    // Задание 2: Создание и Инициализация Списка
    val stringList: List<String> = listOf("Hola", "Amigo", "www")

    // Задание 3: Создание Изменяемого Списка
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

    // Задание 4: Добавление Элементов в Список
    val mutableList4: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    mutableList4.add(6)
    mutableList4.add(7)
    mutableList4.add(8)

    // Задание 5: Удаление Элементов из Списка
    val mutableList5: MutableList<String> = mutableListOf("Hola", "Amigo", "www")
    mutableList5.remove("Hola")

    // Задание 6: Перебор Списка в Цикле
    val list6: List<Int> = listOf(1, 2, 3, 4, 5)
    for (element_list6 in list6) {
        println(element_list6)
    }

    // Задание 7: Получение Элементов Списка по Индексу
    val list7: List<String> = listOf("Hello", "World", "Kotlin")
    val secondElement = list7[1]
    println(secondElement)

    // Задание 8: Перезапись Элементов Списка по Индексу
    val mutableList8: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    mutableList8[2] = 10

    // Задание 9: Объединение Двух Списков
    val mutableList9_1: MutableList<String> = mutableListOf("Hola", "Amigo", "www")
    val mutableList9_2: MutableList<String> = mutableListOf("Warface", "CS2", "EEE")
    val mutableList9_3: MutableList<String> = mutableListOf()

    for (element in mutableList9_3) {
        mutableList9_3.add(element)
    }

    for (element in mutableList9_3) {
        mutableList9_3.add(element)
    }

    // Задание 10: Нахождение Минимального/Максимального Элемента
    val list10: List<Int> = listOf(4, 2, 9, 1, 7)
    var min = list10[0]
    var max = list10[0]

    for (element in list10) {
        if (element < min) {
            min = element
        }
        if (element > max) {
            max = element
        }
    }

    println("Минимум: $min, Максимум: $max")


    // Задание 11: Фильтрация Списка
    val list11: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val evenNumbers: MutableList<Int> = mutableListOf()

    for (element_list11 in list11) {
        if (element_list11 % 2 == 0) {
            evenNumbers.add(element_list11)
        }
    }
    println(evenNumbers)

    /* Работа с Множествами Set */

    // Задание 1: Создание Пустого Множества
    val emptySet: Set<Int> = setOf()

    // Задание 2: Создание и Инициализация Множества
    val immutableSet: Set<Int> = setOf(1, 2, 3)

    // Задание 3: Создание Изменяемого Множества
    val mutableSet: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")

    // Задание 4: Добавление Элементов в Множество
    mutableSet.add("Swift")
    mutableSet.add("Go")

    // Задание 5: Удаление Элементов из Множества
    val mutableSet5: MutableSet<Int> = mutableSetOf(1, 2, 3)
    mutableSet5.remove(2)

    // Задание 6: Перебор Множества в Цикле
    val set6: Set<Int> = setOf(1, 2, 3, 4, 5)
    for (element in set6) {
        println(element)
    }

    // Задание 7: Проверка Наличия Элемента в Множестве
    fun containsElement(set: Set<String>, element: String): Boolean {
        for (item in set) {
            if (item == element) {
                return true
            }
        }
        return false
    }

    val set7 = setOf("Adventure", "Challenge", "Harmony")
    println(containsElement(set7, "Challenge"))  // true

    // Задание 8: Объединение Двух Множеств
    val set8a: Set<String> = setOf("Innovation", "Serenity")
    val set8b: Set<String> = setOf("Swift", "Go")
    val unionSet: MutableSet<String> = mutableSetOf()

    for (item in set8a) {
        unionSet.add(item)
    }
    for (item in set8b) {
        unionSet.add(item)
    }
    println(unionSet)

    // Задание 9: Нахождение Пересечения Множеств
    val set9a: Set<Int> = setOf(1, 2, 3, 4)
    val set9b: Set<Int> = setOf(3, 4, 5, 6)
    val intersectionSet: MutableSet<Int> = mutableSetOf()

    for (itemA in set9a) {
        for (itemB in set9b) {
            if (itemA == itemB) {
                intersectionSet.add(itemA)
            }
        }
    }
    println(intersectionSet)

    // Задание 10: Нахождение Разности Множеств
    val set10a: Set<String> = setOf("Kotlin", "Vision", "Gratitude")
    val set10b: Set<String> = setOf("Discovery", "Unity")
    val differenceSet: MutableSet<String> = mutableSetOf()

    for (itemA in set10a) {
        var found = false
        for (itemB in set10b) {
            if (itemA == itemB) {
                found = true
                break
            }
        }
        if (!found) {
            differenceSet.add(itemA)
        }
    }
    println(differenceSet)

    // Задание 11: Конвертация Множества в Список
    val set11: Set<String> = setOf("Courage", "Balance", "Scala")
    val listFromSet: MutableList<String> = mutableListOf()

    for (item in set11) {
        listFromSet.add(item)
    }
    println(listFromSet)

}

