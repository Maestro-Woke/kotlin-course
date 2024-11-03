package com.maestro.com.maestro.kotlincourse.lesson17.homework

class Geometric_Figure {
    open class GeometricFigure(val name: String)

    open class Polygon(name: String) : GeometricFigure(name)

    class Circle(radius: Double) : GeometricFigure("Circle") {
        val radius = radius
    }

    class Triangle : Polygon("Triangle")

    class Quadrilateral : Polygon("Quadrilateral")

}