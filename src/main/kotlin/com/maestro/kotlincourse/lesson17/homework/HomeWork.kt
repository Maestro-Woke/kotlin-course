package com.maestro.com.maestro.kotlincourse.lesson17.homework

fun main() {
    val bottomContainer = BottomMaterial()
    bottomContainer.addMaterialToBottom("Wood")
    bottomContainer.printContainer()

    val interleavedContainer = InterleavedMaterial()
    interleavedContainer.addMaterialsInterleaved(listOf("first", "second", "third"))
    interleavedContainer.printContainer()

    val alphabeticalContainer = AlphabeticalMaterial()
    alphabeticalContainer.addMaterialAlphabetically("Plastic")
    alphabeticalContainer.addMaterialAlphabetically("Glass")
    alphabeticalContainer.printContainer()

    val keyValueContainer = KeyValueMaterial()
    keyValueContainer.addKeyValueMaterials(mapOf("Key1" to "Value1", "Key2" to "Value2"))
    keyValueContainer.printContainer()
}
