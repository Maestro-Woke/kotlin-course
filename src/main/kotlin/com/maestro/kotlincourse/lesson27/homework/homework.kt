package com.maestro.com.maestro.kotlincourse.lesson27.homework

import kotlin.system.measureTimeMillis

fun main() {
    // Задание 1: Функция timeTracker
    println("Задание 1: Функция timeTracker")
    val myFunction = {
        val list = List(10_000_000) { (0..10_000).random() }
        list.sorted()
    }
    val executionTime = timeTracker(myFunction)
    println("Время выполнения функции: $executionTime мс")

    // Задание 2: Использование apply для инициализации Employee
    println("\nЗадание 2: Использование apply для инициализации Employee")
    val employee = Employee("Николай Соколов", 32, "Аналитик").apply {
        email = "nikolay.sokolov@example.com"
        department = "Аналитический отдел"
    }
    println("Инициализированный объект Employee: $employee")

    // Задание 3: Использование also для логирования
    println("\nЗадание 3: Использование also для логирования")
    val person = Person("Мария Орлова", 27).apply { email = "mariya.orlova@example.com" }
    person.also { logPerson(it) }

    // Задание 4: Использование with для преобразования Person в Employee
    println("\nЗадание 4: Использование with для преобразования Person в Employee")
    val personForConversion = Person("Дмитрий Кузнецов", 45)
    val newEmployee = with(personForConversion) {
        Employee(name, age, "Менеджер проекта").apply { email = "dmitriy.kuznetsov@example.com" }
    }
    println("Преобразованный объект Employee: $newEmployee")

    // Задание 5: Использование run для преобразования и инициализации Employee
    println("\nЗадание 5: Использование run для преобразования и инициализации Employee")
    val personForRun = Person("Анна Волкова", 30).apply { email = "anna.volkova@example.com" }
    val initializedEmployee = personForRun.run {
        Employee(name, age, "Дизайнер").apply {
            email = this@run.email
            department = "Дизайн-студия"
        }
    }
    println("Инициализированный объект Employee с использованием run: $initializedEmployee")

    // Задание 6: Использование let для безопасного преобразования Person в Employee
    println("\nЗадание 6: Использование let для безопасного преобразования Person в Employee")
    val nullablePerson: Person? = Person("Игорь Сми2рнов", 40).apply { email = "igor.smirnov@example.com" }
    val nullableEmployee = nullablePerson?.let {
        Employee(it.name, it.age, "Инженер").apply { email = it.email }
    }
    println("Nullable Employee: $nullableEmployee")

    val nullPerson: Person? = null
    val nullEmployee = nullPerson?.let {
        Employee(it.name, it.age, "Неизвестно")
    }
    println("Null Employee: $nullEmployee")
}

// Задание 1: Функция timeTracker
fun timeTracker(function: () -> List<Int>): Long {
    return measureTimeMillis {
        function()
    }
}

// Классы для работы с scope функциями
class Person(val name: String, val age: Int) {
    var email: String = ""
    override fun toString(): String {
        return "Person(имя='$name', возраст=$age, email='$email')"
    }
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "Общий"
    override fun toString(): String {
        return "Employee(имя='$name', возраст=$age, должность='$position', email='$email', отдел='$department')"
    }
}

// Задание 3: Функция для логирования объекта Person
fun logPerson(person: Person) {
    println("Информация об объекте Person:")
    println("Имя: ${person.name}")
    println("Возраст: ${person.age}")
    println("Email: ${person.email}")
}