package com.maestro.com.maestro.kotlincourse.lesson18.homework


class Logger {
    fun log(message: String) {
        println("INFO: $message")
    }

    fun log(level: String, message: String) {
        val color = when (level) {
            "WARNING" -> "\u001B[33m" // Жёлтый текст
            "ERROR" -> "\u001B[37;41m" // Белый текст на красном фоне
            else -> "\u001B[0m" // Обычный цвет
        }
        println("$color$level: $message\u001B[0m")
    }

    fun log(messages: List<String>) {
        messages.forEach { log(it) }
    }

    fun log(exception: Exception) {
        log("ERROR", exception.message ?: "Unknown error")
    }
}
