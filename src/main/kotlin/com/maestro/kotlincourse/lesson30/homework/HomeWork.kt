package com.maestro.com.maestro.kotlincourse.lesson30.homework


// Задание 1
enum class TestStatus {
    PASS, BROKEN, FAILURE
}

enum class PropertyCategory(val description: String) {
    FLAT("Жилая квартира"),
    VILLA("Загородный дом"),
    BUNGALOW("Лёгкая постройка"),
    CABIN("Дача"),
    PENTHOUSE("Элитное жильё")
}

enum class CelestialBody(val orbitAU: Double, val planetaryMass: Double) {
    MERCURY(0.39, 3.301e23),
    VENUS(0.72, 4.867e24),
    EARTH(1.0, 5.972e24),
    MARS(1.52, 6.417e23),
    JUPITER(5.2, 1.898e27),
    SATURN(9.58, 5.683e26),
    URANUS(19.2, 8.681e25),
    NEPTUNE(30.1, 1.024e26)
}
// Задание 2

fun displaySortedProperties() {
    PropertyCategory.values()
        .sortedBy { it.description.length }
        .map { it.description }
        .forEach(::println)
}

// задание 3

fun processTask(task: () -> Unit): TestStatus {
    return try {
        task()
        TestStatus.PASS
    } catch (assertion: AssertionError) {
        TestStatus.BROKEN
    } catch (exception: Exception) {
        TestStatus.FAILURE
    }
}

// Задание 4

fun filterCelestialBodies(condition: (CelestialBody) -> Boolean): CelestialBody {
    return CelestialBody.values().find(condition)
        ?: error("Не удалось найти подходящий объект!")
}


fun main(){
    // Задание 2
    displaySortedProperties()

    // Задание 3
    val result = processTask {
        check(3 * 3 == 10)
    }
    println(result)

    // Задание 4
    val farPlanet = filterCelestialBodies { it.orbitAU > 15.0 }
    println("Удалённая планета: ${farPlanet.name}")
}