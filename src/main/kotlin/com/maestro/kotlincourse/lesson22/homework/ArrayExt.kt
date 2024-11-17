package com.maestro.com.maestro.kotlincourse.lesson22.homework

fun Array<Int>.toSillyPair(): Pair<Int, Int> {
    val chaos = this.sorted()
    val smallest = chaos.first()
    val biggest = chaos.last()
    println("Я нашёл твоих любимчиков: Малыш $smallest и Великан $biggest")
    return Pair(smallest, biggest)
}