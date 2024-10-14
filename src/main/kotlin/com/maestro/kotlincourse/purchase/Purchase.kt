package com.maestro.com.maestro.kotlincourse.purchase

import java.io.File
import java.security.MessageDigest
import java.time.LocalDateTime
import java.util.UUID

data class Purchase(
    val orderId: String,
    val customerName: String,
    val purchaseDate: String,
    val equipmentType: String,
    val quantity: Int,
    val pricePerUnit: Double,
    val discount: Double,
    val paymentMethod: String
)

fun generatePurchaseFile(purchase: Purchase): File {
    // Проверка входных данных
    validatePurchase(purchase)

    // Расчет общей стоимости с учетом скидки
    val totalPrice = calculateTotalPrice(purchase.pricePerUnit, purchase.quantity, purchase.discount)

    // Формируем строку с данными
    val data = """
        |==============================
        |Покупка горнолыжного снаряжения
        |==============================
        |Идентификатор заказа: ${purchase.orderId}
        |Имя клиента: ${purchase.customerName}
        |Дата покупки: ${purchase.purchaseDate}
        |Тип снаряжения: ${purchase.equipmentType}
        |Количество: ${purchase.quantity}
        |Цена за единицу: ${purchase.pricePerUnit} руб.
        |Скидка: ${purchase.discount}%
        |Итоговая стоимость: $totalPrice руб.
        |Способ оплаты: ${purchase.paymentMethod}
        |------------------------------
        |Дата создания файла: ${LocalDateTime.now()}
        |Подписано хэш-кодом: ${generateHash(purchase)}
    """.trimMargin()

    // Создаем файл и записываем в него данные
    val file = File("PurchaseDetails_${purchase.orderId}.txt")
    file.writeText(data)

    return file
}

fun validatePurchase(purchase: Purchase) {
    require(purchase.customerName.isNotBlank()) { "Имя клиента не может быть пустым" }
    require(purchase.purchaseDate.isNotBlank()) { "Дата покупки не может быть пустой" }
    require(purchase.equipmentType.isNotBlank()) { "Тип снаряжения не может быть пустым" }
    require(purchase.quantity > 0) { "Количество должно быть больше нуля" }
    require(purchase.pricePerUnit > 0) { "Цена за единицу должна быть больше нуля" }
    require(purchase.discount in 0.0..100.0) { "Скидка должна быть от 0 до 100%" }
}

fun calculateTotalPrice(pricePerUnit: Double, quantity: Int, discount: Double): Double {
    val total = pricePerUnit * quantity
    return total - (total * discount / 100)
}

fun generateHash(purchase: Purchase): String {
    val input = purchase.orderId + purchase.customerName + purchase.purchaseDate +
            purchase.equipmentType + purchase.quantity + purchase.pricePerUnit +
            purchase.discount + purchase.paymentMethod
    val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
    return bytes.joinToString("") { "%02x".format(it) }
}

// Пример использования
fun main() {
    val purchase = Purchase(
        orderId = UUID.randomUUID().toString(),
        customerName = "Maestro Woke",
        purchaseDate = "2024-10-14",
        equipmentType = "Лыжный комплект",
        quantity = 2,
        pricePerUnit = 13355.0,
        discount = 10.0,
        paymentMethod = "Кредитная карта"
    )

    val file = generatePurchaseFile(purchase)
    println("Файл сгенерирован: ${file.absolutePath}")
}
