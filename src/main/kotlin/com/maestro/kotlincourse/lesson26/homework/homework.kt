package com.maestro.com.maestro.kotlincourse.lesson26.homework

fun main() {
    // Задания на отработку синтаксиса:

    // 1. execute
    println("Задание 1: Функция, принимающая функцию без аргументов и возвращаемого значения")
    execute { println("Hello from execute!") }

    // 2. callFunction
    println("\nЗадание 2: Функция, принимающая функцию с Int и возвращающая String")
    val callResult = callFunction { number -> "You passed $number" }
    println(callResult)

    // 3. processExtension
    println("\nЗадание 3: Функция, принимающая функцию-расширение дл3я Int")
    val extensionResult = processExtension { input -> this > input.length }
    println(extensionResult)

    // 4. checkDoubles
    println("\nЗадание 4: Функция с двумя Double и возвращающая Boolean")
    val doublesCheck = checkDoubles { a, b -> a > b }
    println(doublesCheck)

    // 5. wrapInList
    println("\nЗадание 5: Функция с дженериком T и возвращающая List<T>")
    val wrappedList = wrapInList({ it * 2 }, 5)
    println(wrappedList)

    // 6. createFunction
    println("\nЗадание 6: Функция, принимающая функцию String -> (Int -> Boolean)")
    val generatedFunc = createFunction { prefix -> { num -> num > prefix.length } }
    println(generatedFunc(10)) // Проверка возвращаемой функции

    // 7. combineData
    println("\nЗадание 7: Функция с List<Int>, Set<String> и возвращающая Map<String, Int>")
    val combinedMap = combineData(
        listOf(1, 2, 3),
        setOf("a", "b", "c")
    ) { numbers, words -> words.associateWith { numbers.sum() } }
    println(combinedMap)

    // 8. formatNumber
    println("\nЗадание 8: Функция возвращающая строку (принимает Int и функцию-форматтер)")
    val formatted = formatNumber(42) { number -> "Number: $number" }
    println(formatted)

    // 9. returnNestedFunction
    println("\nЗадание 9: Функция, принимающая функцию, которая возвращает функцию")
    val nestedFunc = returnNestedFunction { { println("Hello from nested function!") } }
    nestedFunc()

    // Задания на разработку кода:

    // 1. filterStrings
    println("\nЗадание 10: filterStrings — фильтрация строк")
    val filteredStrings = filterStrings(listOf("Zorg", "Holm", "Sup", "Cof")) { it.length > 3 }
    println(filteredStrings)

    // 2. applyToNumbers
    println("\nЗадание 11: applyToNumbers — преобразование чисел")
    val transformedNumbers = applyToNumbers(listOf(1, 2, 3, 4)) { it * it }
    println(transformedNumbers)

    // 3. sumByCondition
    println("\nЗадание 12: sumByCondition — сумма чисел, соответствующих условию")
    val sumOfEvens = sumByCondition(listOf(1, 2, 3, 4)) { it % 2 == 0 }
    println(sumOfEvens)

    // 4. combineAndTransform
    println("\nЗадание 13: combineAndTransform — объединение и преобразование коллекций")
    val transformedCollection = combineAndTransform(listOf(1, 2), listOf(3, 4)) { a, b -> (a + b).map { it.toString() } }
    println(transformedCollection)
}

// Функции:

// 1. Функция, принимающая функцию без аргументов и возвращаемого значения
fun execute(action: () -> Unit) {
    action()
}

// 2. Функция, принимающая функцию с Int и возвращающая String
fun callFunction(func: (Int) -> String): String {
    return func(42)
}

// 3. Функция, принимающая функцию-расширение для Int
fun processExtension(func: Int.(String) -> Boolean): Boolean {
    return 10.func("Fin")
}

// 4. Функция с двумя Double и возвращающая Boolean
fun checkDoubles(func: (Double, Double) -> Boolean): Boolean {
    return func(3.14, 2.71)
}

// 5. Функция с дженериком T и возвращающая List<T>
fun <T> wrapInList(func: (T) -> T, value: T): List<T> {
    return listOf(func(value))
}

// 6. Функция, принимающая функцию String -> (Int -> Boolean)
fun createFunction(func: (String) -> (Int) -> Boolean): (Int) -> Boolean {
    return func("Input")
}

// 7. Функция с List<Int>, Set<String> и возвращающая Map<String, Int>
fun combineData(
    numbers: List<Int>,
    words: Set<String>,
    transform: (List<Int>, Set<String>) -> Map<String, Int>
): Map<String, Int> {
    return transform(numbers, words)
}

// 8. Функция возвращающая строку (принимает Int и функцию-форматтер)
fun formatNumber(value: Int, formatter: (Int) -> String): String {
    return formatter(value)
}

// 9. Функция, принимающая функцию, которая возвращает функцию
fun returnNestedFunction(func: () -> (() -> Unit)): (() -> Unit) {
    return func()
}

// 10. filterStrings — фильтрация строк
fun filterStrings(strings: List<String>, filter: (String) -> Boolean): List<String> {
    return strings.filter(filter)
}

// 11. applyToNumbers — преобразование чисел
fun applyToNumbers(numbers: List<Int>, transformer: (Int) -> Int): List<Int> {
    return numbers.map(transformer)
}

// 12. sumByCondition — сумма чисел, соответствующих условию
fun sumByCondition(numbers: List<Int>, condition: (Int) -> Boolean): Int {
    return numbers.filter(condition).sum()
}

// 13. combineAndTransform — объединение и преобразование коллекций
fun <T, R> combineAndTransform(
    first: Collection<T>,
    second: Collection<T>,
    combiner: (Collection<T>, Collection<T>) -> Collection<R>
): Collection<R> {
    return combiner(first, second)
}