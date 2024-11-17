package com.maestro.com.maestro.kotlincourse.lesson22.homework

fun <A, B> Pair<A, B>.revertWithChaos(): Pair<B, A> {
    println("Переворачиваю пару: $this! Теперь будет наоборот.")
    return Pair(this.second, this.first)
}