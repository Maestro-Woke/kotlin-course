package com.maestro.com.maestro.kotlincourse.lesson21.homework

fun main() {
    // использование toMap
    val keys = listOf("e", "v", "l")
    val values = listOf(10, 22, 1)
    val map = toMap(keys, values)
    println(map)

    // использование getMiddleElement
    val numbers = listOf(1, 2, 3, 4, 5)
    println(getMiddleElement(numbers))

    // использование ListHolder
    val listHolder = ListHolder<String>()
    listHolder.addElement("Kitty")
    listHolder.addElement("Case")
    println(listHolder.getAllElements())

    // использование PhrasesToListOfStrings
    val mapper = PhrasesToListOfStrings()
    println(mapper.transform("Kitty Case Erp"))
    println(mapper.transformList(listOf("Kitty Case", "Kumicho Dragon")))

    // использование StringValidator
    val stringValidator = StringValidator()
    println(stringValidator.validate("Test String")) // true
    println(stringValidator.validate("    ")) // false

    // использование OddValidator
    val oddValidator = OddValidator()
    println(oddValidator.validate(4)) // true
    println(oddValidator.validate(5)) // false

    // использование ListValidator
    val listValidator = ListValidator<Number>()
    println(listValidator.validate(listOf(1, 2, 3))) // true
    println(listValidator.validate(listOf(1, null, 3))) // false
}