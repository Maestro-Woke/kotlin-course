package com.maestro.com.maestro.kotlincourse.lesson17.homework

abstract class Materials {
    protected val materials = mutableListOf<String>()

    fun extractMaterial(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

class BottomMaterial : Materials() {
    fun addMaterialToBottom(material: String) {
        materials.add(0, material)
    }
}

class InterleavedMaterial : Materials() {
    fun addMaterialsInterleaved(newMaterials: List<String>) {
        newMaterials.forEachIndexed { index, material ->
            if (index * 2 < materials.size) {
                materials.add(index * 2, material)
            } else {
                materials.add(material) // Добавляем в конец, если индекс выходит за границы
            }
        }
    }
}

class AlphabeticalMaterial : Materials() {
    fun addMaterialAlphabetically(material: String) {
        materials.add(material)
        materials.sort()
    }
}

class KeyValueMaterial : Materials() {
    fun addKeyValueMaterials(keyValueMap: Map<String, String>) {
        keyValueMap.forEach { (key, value) ->
            materials.add(0, key)
            materials.add(value)
        }
    }
}
