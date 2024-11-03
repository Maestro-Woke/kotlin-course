package com.maestro.com.maestro.kotlincourse.lesson18.homework

    class ShoppingCart {
        private val items = mutableMapOf<String, Int>()

        fun addToCart(itemId: String) {
            items[itemId] = items.getOrDefault(itemId, 0) + 1
        }

        fun addToCart(itemId: String, amount: Int) {
            items[itemId] = items.getOrDefault(itemId, 0) + amount
        }

        fun addToCart(itemsToAdd: Map<String, Int>) {
            for ((itemId, amount) in itemsToAdd) {
                items[itemId] = items.getOrDefault(itemId, 0) + amount
            }
        }

        // Добавляет по одной единице для каждого товара из списка itemId
        fun addToCart(itemIds: List<String>) {
            for (itemId in itemIds) {
                items[itemId] = items.getOrDefault(itemId, 0) + 1
            }
        }

        // Переопределённый метод toString для красивого форматирования содержимого
        override fun toString(): String {
            val totalItems = items.values.sum()
            val formattedItems = items.entries.joinToString("\n") { (itemId, quantity) ->
                "Item ID: $itemId, Quantity: $quantity"
            }
            return "Shopping Cart:\n$formattedItems\nTotal unique items: ${items.size}\nTotal quantity: $totalItems"
        }
    }