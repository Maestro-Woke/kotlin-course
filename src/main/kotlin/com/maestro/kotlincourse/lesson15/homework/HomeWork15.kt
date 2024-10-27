package com.maestro.com.maestro.kotlincourse.lesson15.homework

// Класс Party
class Party(val location: String, val attendees: Int) {
    fun details() {
        println("Место проведения: $location, Количество гостей: $attendees")
    }
}

// Класс Emotion
class Emotion(val type: String, val intensity: Int) {
    fun express() {
        val description = when (intensity) {
            in 1..3 -> "слабо выраженная"
            in 4..7 -> "умеренно выраженная"
            in 8..10 -> "сильно выраженная"
            else -> "неизвестной интенсивности"
        }
        println("Эмоция: $type, Интенсивность: $description")
    }
}

// Объект Moon
object Moon {
    var isVisible: Boolean = true
    var phase: String = "Full Moon"

    fun showPhase() {
        val visibility = if (isVisible) "видна" else "не видна"
        println("Фаза Луны: $phase, Луна $visibility")
    }
}

// Дата-класс Product
data class Product(val name: String, val price: Double, val quantity: Int)

// Класс Concert
class Concert(val band: String, val location: String, val cost: Double, val capacity: Int) {
    private var ticketsSold: Int = 0

    fun details() {
        println("Группа: $band, Место проведения: $location, Стоимость билета: $cost, Вместимость: $capacity, Проданные билеты: $ticketsSold")
    }

    fun buyTicket(): Boolean {
        return if (ticketsSold < capacity) {
            ticketsSold++
            println("Билет куплен. Продано билетов: $ticketsSold")
            true
        } else {
            println("Все билеты проданы.")
            false
        }
    }
}

// Класс Item для представления предмета
data class Item(val name: String, val size: Int)

// Класс Shelf (Полка стеллажа)
class Shelf(private val capacity: Int) {
    private val items = mutableListOf<Item>()

    // Метод добавления предмета на полку
    fun addItem(item: Item): Boolean {
        if (canAccommodate(item)) {
            items.add(item)
            println("Предмет \"${item.name}\" добавлен на полку.")
            return true
        }
        println("Недостаточно места для \"${item.name}\".")
        return false
    }

    // Метод удаления предмета с полки
    fun removeItem(itemName: String): Boolean {
        val item = items.find { it.name == itemName }
        return if (item != null) {
            items.remove(item)
            println("Предмет \"$itemName\" удален с полки.")
            true
        } else {
            println("Предмет \"$itemName\" не найден на полке.")
            false
        }
    }

    // Метод проверки возможности размещения предмета на полке
    fun canAccommodate(item: Item): Boolean {
        return items.sumOf { it.size } + item.size <= capacity
    }

    // Проверка наличия предмета на полке
    fun contains(itemName: String): Boolean {
        return items.any { it.name == itemName }
    }

    // Получение списка предметов на полке
    fun getItems(): List<Item> {
        return items.toList()
    }

    // Получение оставшейся вместимости полки
    fun remainingCapacity(): Int {
        return capacity - items.sumOf { it.size }
    }
}


// Класс Rack (Стеллаж)
class Rack(private val maxShelves: Int) {
    private val shelves = mutableListOf<Shelf>()

    // Метод добавления полки в стеллаж
    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size < maxShelves && !shelves.contains(shelf)) {
            shelves.add(shelf)
            println("Полка добавлена.")
            return true
        }
        println("Невозможно добавить полку.")
        return false
    }

    // Метод удаления полки из стеллажа
    fun removeShelf(index: Int): Boolean {
        if (index in shelves.indices) {
            shelves.removeAt(index)
            println("Полка удалена.")
            return true
        }
        println("Полка не найдена.")
        return false
    }

    // Добавление предмета на самую свободную полку
    fun addItem(item: Item): Boolean {
        val shelf = shelves.maxByOrNull { it.remainingCapacity() }
        return if (shelf != null && shelf.canAccommodate(item)) {
            shelf.addItem(item)
        } else {
            println("Недостаточно места на всех полках.")
            false
        }
    }

    // Удаление предмета из стеллажа
    fun removeItem(itemName: String): Boolean {
        for (shelf in shelves) {
            if (shelf.contains(itemName)) {
                return shelf.removeItem(itemName)
            }
        }
        println("Предмет \"$itemName\" не найден.")
        return false
    }

    // Проверка наличия предмета в стеллаже
    fun contains(itemName: String): Boolean {
        return shelves.any { it.contains(itemName) }
    }

    // Получение списка всех полок
    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }

    // Печать содержимого стеллажа
    fun printContents() {
        shelves.forEachIndexed { index, shelf ->
            val items = shelf.getItems().joinToString { it.name }
            println("Полка $index: Вместимость ${shelf.remainingCapacity()}/${shelf.getItems().sumOf { it.size }}, Предметы: [$items]")
        }
    }

    // Сложное удаление полки с перераспределением предметов
    fun advancedRemoveShelf(index: Int): List<Item> {
        if (index !in shelves.indices) {
            println("Полка не найдена.")
            return emptyList()
        }
        val itemsToReallocate = shelves[index].getItems().sortedByDescending { it.size }
        shelves.removeAt(index)
        val notPlacedItems = mutableListOf<Item>()

        for (item in itemsToReallocate) {
            if (!addItem(item)) {
                notPlacedItems.add(item)
            }
        }
        println("Полка удалена. Не удалось разместить следующие предметы: ${notPlacedItems.joinToString { it.name }}")
        return notPlacedItems
    }
}



fun main() {
    val rack = Rack(maxShelves = 3)
    val shelf1 = Shelf(capacity = 20)
    val shelf2 = Shelf(capacity = 15)

    rack.addShelf(shelf1)
    rack.addShelf(shelf2)

    val item1 = Item("Book", 5)
    val item2 = Item("Laptop", 7)
    val item3 = Item("Lamp", 10)

    rack.addItem(item1)
    rack.addItem(item2)
    rack.addItem(item3)

    rack.printContents()

    val notPlacedItems = rack.advancedRemoveShelf(0)
    println("Не удалось разместить: ${notPlacedItems.joinToString { it.name }}")

    rack.printContents()
}

