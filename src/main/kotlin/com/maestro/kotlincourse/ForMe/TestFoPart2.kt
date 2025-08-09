package com.maestro.kotlincourse.ForMe

// Создай класс Counter, который увеличивает и сбрасывает счётчик

/*class Counter(
    private var counter: Int = 0
) {
    init {
        println("Counter initialized with value $counter")
    }

    fun increment() {
        counter++
        println("Counter incremented to $counter")
    }

    fun reset() {
        counter = 0
        println("Counter reset to $counter")
    }

    fun getValue(): Int {
        return counter
    }
}

fun main() {
    val counter = Counter()

    counter.increment()  // 1
    counter.increment()  // 2
    counter.reset()      // 0
    counter.increment()  // 1
}*/

// Базовый класс Transport, наследники — Car, Bicycle, Bus, каждый со своим move().

/*open class Transport(){
    open fun move(){
        println("Transport is moving...")
    }

    class Car : Transport(){
        override fun move(){
            println("Car is moving...")
        }
    }

    class Bicycle : Transport(){
        override fun move(){
            println("Bicycle is moving...")
        }
    }

    class Bus : Transport(){
        override fun move(){
            println("Bus is moving...")
        }
    }
}

fun main() {
    val transportList = listOf(Transport(), Transport.Car(), Transport.Bicycle(), Transport.Bus())

    for (transport in transportList) {
        transport.move()
    }
} */

// Создай Animal, у которого есть sound(), и переопредели в Cat, Dog, Cow.
/*open class Animal(){
    open fun sound(){
        println("")
    }

    class Cat : Animal(){
        override fun sound(){
            println("Meow")
        }
    }

    class Dog : Animal(){
        override fun sound(){
            println("Woof")
        }
    }

    class Cow : Animal(){
        override fun sound(){
            super.sound()
            println("Mooooo")
        }
    }
}

fun main() {
    val animals = listOf(Animal(), Animal.Cat(), Animal.Dog(), Animal.Cow())
    for (animal in animals) {
        animal.sound()
    }
}*/

// Сделай абстрактный Shape и реализуй Rectangle, Circle, Triangle.

/* abstract class Shape {
    abstract fun area(): Double
}

// Прямоугольник
class Rectangle(val height: Double, val width: Double) : Shape() {
    override fun area(): Double {
        return height * width
    }
}

// Круг
class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

// Треугольник (по формуле: 1/2 * основание * высота)
class Triangle(val base: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return 0.5 * base * height
    }
}

// Пример использования
fun main() {
    val shapes = listOf(
        Rectangle(10.0, 5.0),
        Circle(4.0),
        Triangle(6.0, 3.0)
    )

    for (shape in shapes) {
        println("Площадь: ${shape.area()}")
    }
}*/


// interface Drawable, interface Clickable, класс Button, который реализует оба.

/* interface Drawable{
    fun draw()
}


interface Clickable{
    fun click()
}

class Button : Drawable, Clickable {
    override fun click() = println("I'm clicked")
    override fun draw() = println("I'm drawn")
}

fun main() {
    val button = Button()
    button.click()
    button.draw()
}*/

// Сделай interface Fightable, реализуй его в Warrior, Wizard, Archer.

/*interface Fightable {
    fun move()
    fun attack()
}

class Warrior : Fightable {
    override fun move() {
        println("Warrior runs forward with a shield")
    }

    override fun attack() {
        println("Warrior swings a sword")
    }
}

class Wizard : Fightable {
    override fun move() {
        println("Wizard runs forward")
    }

    override fun attack() {
       println("Wizard swings a sword")
    }
}

class Archer : Fightable {
    override fun move() {
        println("Archer runs forward")
    }

    override fun attack() {
        println("Archer swings a sword")
    }
}

fun main() {
    val fighter1 = Warrior()
    val fighter2 = Wizard()
    val fighter3 = Archer()

    fighter1.move(); fighter1.attack()
    fighter2.move(); fighter2.attack()
    fighter3.move(); fighter3.attack()
} */

// Добавь интерфейс Speakable, реализующий метод speak() у разных объектов.

/*interface Speakable{
    fun speak()
}

class Spanish: Speakable{
    override fun speak() {
        println("¡Hola! ¿Cómo estás?")
    }

}

class Russian: Speakable{
    override fun speak() {
        println("Привет! Как дела?")
    }
}


class English: Speakable{
    override fun speak() {
        println("Hello! How are you?")
    }
}

fun main() {
    val speak1 = Spanish()
    val speak2 = Russian()
    val speak3 = English()

    speak1.speak()
    speak2.speak()
    speak3.speak()
} */