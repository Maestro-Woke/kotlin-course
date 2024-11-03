package com.maestro.com.maestro.kotlincourse.lesson18.homework

class Shape {
    abstract class Shape {
        open fun calculateArea(): Double = 0.0
    }

    class Sphere(private val radius: Double) : Shape() {
        override fun calculateArea(): Double = 4 * Math.PI * radius * radius
    }

    class Rectangle(private val length: Double, private val width: Double) : Shape() {
        override fun calculateArea(): Double = length * width
    }

    class Polygon(private val base: Double, private val height: Double, private val angle: Double) : Shape() {
        override fun calculateArea(): Double = 0.5 * base * height * Math.sin(Math.toRadians(angle))
    }
}