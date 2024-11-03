package com.maestro.com.maestro.kotlincourse.lesson18.homework

class Printer {
    abstract class AbstractPrinter {
        abstract fun display(text: String)

        protected fun processAndPrintWords(text: String, printFunction: (String) -> Unit) {
            text.split(" ").forEach(printFunction)
        }
    }

    class TonerPrinter : AbstractPrinter() {
        override fun display(text: String) {
            processAndPrintWords(text) { segment ->
                println("${DisplayColor.BLACK}$segment${DisplayColor.RESET}")  // Черный текст на белом фоне
            }
        }
    }

    class DyePrinter : AbstractPrinter() {
        private val palette = listOf(
            DisplayColor.RED to DisplayColor.WHITE_BG,
            DisplayColor.GREEN to DisplayColor.CYAN_BG,
            DisplayColor.BLUE to DisplayColor.YELLOW_BG
        )

        override fun display(text: String) {
            var colorIndex = 0
            processAndPrintWords(text) { segment ->
                val (textColor, backgroundColor) = palette[colorIndex % palette.size]
                println("$textColor$backgroundColor$segment${DisplayColor.RESET}")
                colorIndex++
            }
        }
    }

    object DisplayColor {
        const val RESET = "\u001B[0m"
        const val BLACK = "\u001B[30m"
        const val RED = "\u001B[31m"
        const val GREEN = "\u001B[32m"
        const val BLUE = "\u001B[34m"
        const val WHITE_BG = "\u001B[47m"
        const val CYAN_BG = "\u001B[46m"
        const val YELLOW_BG = "\u001B[43m"
    }

}