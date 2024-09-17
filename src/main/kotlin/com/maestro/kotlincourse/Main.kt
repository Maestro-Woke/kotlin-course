package com.maestro.com.maestro.kotlincourse


import kotlinx.coroutines.*
import kotlin.math.*
import kotlin.random.Random

// Комплексное число
data class Complex(val real: Double, val imag: Double) {
    operator fun plus(other: Complex): Complex = Complex(real + other.real, imag + other.imag)
    operator fun times(other: Complex): Complex = Complex(real * other.real - imag * other.imag, real * other.imag + imag * other.real)
    fun magnitude(): Double = sqrt(real * real + imag * imag)
}

// Функция для расчёта Мандельброта для одного пикселя
fun mandelbrot(c: Complex, maxIterations: Int): Int {
    var z = Complex(0.0, 0.0)
    var iterations = 0
    while (z.magnitude() <= 2.0 && iterations < maxIterations) {
        z = z * z + c
        iterations++
    }
    return iterations
}

// Генерация фрактала Мандельброта
suspend fun generateMandelbrot(width: Int, height: Int, maxIterations: Int, xMin: Double, xMax: Double, yMin: Double, yMax: Double) {
    val aspectRatio = width.toDouble() / height
    val pixels = Array(height) { IntArray(width) }

    coroutineScope {
        for (y in 0 until height) {
            launch {
                val imaginary = yMin + y * (yMax - yMin) / height
                for (x in 0 until width) {
                    val real = xMin + x * (xMax - xMin) / width
                    val c = Complex(real, imaginary)
                    val color = mandelbrot(c, maxIterations)
                    pixels[y][x] = color
                }
            }
        }
    }

    // Печать фрактала в виде ASCII (на экране)
    for (row in pixels) {
        for (pixel in row) {
            print(if (pixel == maxIterations) " " else "*")
        }
        println()
    }
}

// Рекурсивная генерация "дерева Пифагора"
fun generatePythagorasTree(x1: Double, y1: Double, angle: Double, length: Double, depth: Int) {
    if (depth == 0) return

    // Конечные точки ветви
    val x2 = x1 + length * cos(angle)
    val y2 = y1 + length * sin(angle)

    // Вывод ветви (в данном случае просто вывод координат)
    println("Ветвь: ($x1, $y1) -> ($x2, $y2)")

    // Рекурсивное создание двух новых ветвей с новыми углами и длиной
    generatePythagorasTree(x2, y2, angle - PI / 6, length * 0.75, depth - 1)
    generatePythagorasTree(x2, y2, angle + PI / 6, length * 0.75, depth - 1)
}

// Симуляция отжига (алгоритм оптимизации)
fun simulatedAnnealing(function: (Double) -> Double, initialTemp: Double, coolingRate: Double, maxSteps: Int): Double {
    var temp = initialTemp
    var currentSolution = Random.nextDouble(-10.0, 10.0)
    var bestSolution = currentSolution
    var bestCost = function(currentSolution)

    for (step in 0 until maxSteps) {
        val nextSolution = currentSolution + Random.nextDouble(-1.0, 1.0)
        val nextCost = function(nextSolution)

        if (nextCost < bestCost || exp((bestCost - nextCost) / temp) > Random.nextDouble()) {
            currentSolution = nextSolution
            bestCost = nextCost
        }

        if (bestCost < function(bestSolution)) {
            bestSolution = currentSolution
        }

        temp *= coolingRate

        if (step % 100 == 0) {
            println("Шаг $step: лучшая найденная точка = $bestSolution, значение = $bestCost")
        }
    }

    return bestSolution
}

fun main() = runBlocking {
    val width = 100
    val height = 50
    val maxIterations = 1000
    println("Генерация фрактала Мандельброта:")

    // Параллельная генерация множества Мандельброта
    launch {
        generateMandelbrot(width, height, maxIterations, xMin = -2.0, xMax = 1.0, yMin = -1.5, yMax = 1.5)
    }

    // Генерация рекурсивного дерева Пифагора
    println("Генерация дерева Пифагора:")
    generatePythagorasTree(0.0, 0.0, PI / 2, length = 10.0, depth = 10)

    // Запуск алгоритма отжига для минимизации сложной функции
    println("Запуск симуляции отжига для оптимизации:")
    val bestSolution = simulatedAnnealing(
        function = { x -> x * sin(x) + x * cos(x) },
        initialTemp = 1000.0,
        coolingRate = 0.995,
        maxSteps = 10000
    )
    println("Оптимальное решение найдено: $bestSolution")
}





