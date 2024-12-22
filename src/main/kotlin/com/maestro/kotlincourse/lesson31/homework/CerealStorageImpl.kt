package com.maestro.com.maestro.kotlincourse.lesson31.homework

class CerealStorageImpl(
    override val containerCapacity: Float,
    override val storageCapacity: Float
) : CerealStorage {

    private val storage = mutableMapOf<Cereal, Float>()

    override fun addCereal(cereal: Cereal, amount: Float): Float {
        require(amount >= 0) { "Количество добавляемой крупы не может быть отрицательным" }

        val currentAmount = storage.getOrDefault(cereal, 0f)
        val spaceLeft = containerCapacity - currentAmount

        if (amount > spaceLeft) {
            if (storage.values.sum() + (amount - spaceLeft) > storageCapacity) {
                throw IllegalStateException("Хранилище переполнено!")
            }
            storage[cereal] = containerCapacity
            return amount - spaceLeft
        } else {
            storage[cereal] = currentAmount + amount
            return 0f
        }
    }

    override fun getCereal(cereal: Cereal, amount: Float): Float {
        require(amount >= 0) { "Количество забираемой крупы не может быть отрицательным" }

        val currentAmount = storage[cereal] ?: 0f
        return if (currentAmount >= amount) {
            storage[cereal] = currentAmount - amount
            amount
        } else {
            storage[cereal] = 0f
            currentAmount
        }
    }

    override fun removeContainer(cereal: Cereal): Boolean {
        val currentAmount = storage[cereal] ?: return false
        return if (currentAmount == 0f) {
            storage.remove(cereal)
            true
        } else {
            false
        }
    }

    override fun getAmount(cereal: Cereal): Float {
        return storage[cereal] ?: 0f
    }

    override fun getSpace(cereal: Cereal): Float {
        return containerCapacity - (storage[cereal] ?: 0f)
    }

    override fun toString(): String {
        return "CerealStorage(containerCapacity=$containerCapacity, storageCapacity=$storageCapacity, storage=$storage)"
    }
}