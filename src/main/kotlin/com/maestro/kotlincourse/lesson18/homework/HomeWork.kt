package com.maestro.com.maestro.kotlincourse.lesson18.homework

import com.maestro.com.maestro.kotlincourse.lesson18.homework.Animal.*
import com.maestro.com.maestro.kotlincourse.lesson18.homework.Shape.*
import com.maestro.com.maestro.kotlincourse.lesson18.homework.Printer.*


fun main() {
    // Задание 1: Животные и Их Звуки
    val creatures = listOf(Hound(), Feline(), Sparrow())
    creatures.forEach { it.emitSound() }

    // Задание 2: Геометрические Фигуры и Их Площадь
    val figures = listOf(
        Sphere(5.0),
        Rectangle(4.0, 6.0),
        Polygon(3.0, 4.0, 90.0)
    )
    figures.forEach { println("Расчёт: ${it.calculateArea()}") }

    // Задание 3: Принтер
    val tonerPrinter = TonerPrinter()
    val dyePrinter = DyePrinter()
    tonerPrinter.display("Тестирование принтера с черным текстом.")
    dyePrinter.display("Тестирование красочного принтера с красочной печатью.")



    // Тестирование ShoppingCart
    val cart = ShoppingCart()
    cart.addToCart("item1")
    cart.addToCart("item2", 3)
    cart.addToCart(mapOf("item3" to 5, "item4" to 2))
    cart.addToCart(listOf("item1", "item2", "item5"))
    println(cart)

    // Тестирование Logger
    val logger = Logger()
    logger.log("This is an info message.")
    logger.log("WARNING", "This is a warning message.")
    logger.log("ERROR", "This is an error message.")
    logger.log(listOf("First info message", "Second info message", "Third info message"))
    logger.log(Exception("This is an exception message"))
}
