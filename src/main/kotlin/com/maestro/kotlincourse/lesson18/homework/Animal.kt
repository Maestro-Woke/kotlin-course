package com.maestro.com.maestro.kotlincourse.lesson18.homework

class Animal {
    abstract class Creature {
        open fun emitSound() {
            println("This creature makes no sound.")
        }
    }

    class Hound : Creature() {
        override fun emitSound() {
            println("${Color.BLUE}Woof${Color.RESET}")  // Звук Hound (синий)
        }
    }

    class Feline : Creature() {
        override fun emitSound() {
            println("${Color.PURPLE}Purr${Color.RESET}")  // Звук Feline (фиолетовый)
        }
    }

    class Sparrow : Creature() {
        override fun emitSound() {
            println("${Color.YELLOW}Chirp${Color.RESET}")  // Звук Sparrow (желтый)
        }
    }

    object Color {
        const val RESET = "\u001B[0m"
        const val BLUE = "\u001B[34m"
        const val PURPLE = "\u001B[35m"
        const val YELLOW = "\u001B[33m"
    }

}