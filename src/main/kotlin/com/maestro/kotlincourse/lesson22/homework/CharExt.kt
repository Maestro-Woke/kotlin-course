package com.maestro.com.maestro.kotlincourse.lesson22.homework

fun Char?.charComedy(x: Int, y: Int, flag: Boolean) {
    this?.let {
        println("Символ $it устроил шоу! x=$x, y=$y, шутка про флаг: ${if (flag) "синий" else "зелёный"}")
    } ?: println("Символа нет, а шоу продолжается!")
}