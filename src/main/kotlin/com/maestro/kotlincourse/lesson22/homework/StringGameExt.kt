package com.maestro.com.maestro.kotlincourse.lesson22.homework

fun String.displayAsGame(players: List<String>) {
    println("🔤 Давайте устроим смешную раскладку!")
    this.forEachIndexed { index, char ->
        val player = players.getOrElse(index % players.size) { "Чудак$index" }
        println("$player 🎲 $char")
    }
}