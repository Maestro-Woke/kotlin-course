package com.maestro.com.maestro.kotlincourse.lesson17.homework

class Furniture {
    open class Furniture(val type: String)

    class Chair : Furniture("Chair")

    class Table : Furniture("Table")

}