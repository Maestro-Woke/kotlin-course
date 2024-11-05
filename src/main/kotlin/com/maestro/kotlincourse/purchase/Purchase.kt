package com.maestro.kotlincourse.purchase

import java.io.File
import java.security.MessageDigest
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

data class Purchase(
    val orderId: String,
    val customerFullName: String,
    val equipmentType: String,
    val quantity: Int,
    val pricePerUnit: Double,
    val discount: Double,
    val paymentMethod: String
) {
    var bonusPoints: Int = 0
}

fun generatePurchaseFile(purchase: Purchase): File {
    validatePurchase(purchase)

    // Расчет общей стоимости и бонусов
    val totalPrice = calculateTotalPrice(purchase.pricePerUnit, purchase.quantity, purchase.discount)
    applyBonusPoints(purchase, totalPrice)

    val purchaseDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    val data = """
        |Дата создания файла: ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}
        |Подписано хэш-кодом: ${generateHash(purchase)}
        |==============================
        |Идентификатор заказа: ${purchase.orderId}
        |Имя клиента: ${purchase.customerFullName}
        |Дата покупки: $purchaseDate
        |Тип снаряжения: ${purchase.equipmentType}
        |Количество: ${purchase.quantity}
        |Цена за единицу: ${purchase.pricePerUnit} руб.
        |Скидка: ${purchase.discount}%
        |Итоговая стоимость: $totalPrice руб.
        |Бонусные баллы: ${purchase.bonusPoints} 
        |Способ оплаты: ${purchase.paymentMethod}
        |------------------------------
        |Чек о покупке горнолыжного снаряжения
    """.trimMargin()

    val file = File("PurchaseDetails_${purchase.orderId}.txt")
    file.writeText(data)

    return file
}

fun validatePurchase(purchase: Purchase) {
    require(purchase.customerFullName.isNotBlank()) { "Имя клиента не может быть пустым" }
    require(purchase.equipmentType.isNotBlank()) { "Тип снаряжения не может быть пустым" }
    require(purchase.quantity > 0) { "Количество должно быть больше нуля" }
    require(purchase.pricePerUnit > 0) { "Цена за единицу должна быть больше нуля" }
    require(purchase.discount in 0.0..100.0) { "Скидка должна быть от 0 до 100%" }
}

fun calculateTotalPrice(pricePerUnit: Double, quantity: Int, discount: Double): Double {
    val total = pricePerUnit * quantity
    return total - (total * discount / 100)
}

// Новая функция для начисления бонусных баллов
fun applyBonusPoints(purchase: Purchase, totalPrice: Double) {
    purchase.bonusPoints = (totalPrice / 100).toInt()
}

fun generateHash(purchase: Purchase): String {
    val input = purchase.orderId + purchase.customerFullName +
            purchase.equipmentType + purchase.quantity + purchase.pricePerUnit +
            purchase.discount + purchase.paymentMethod
    val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
    return bytes.joinToString("") { "%02x".format(it) }
}

// Пример использования
fun main() {
    val purchase = Purchase(
        orderId = UUID.randomUUID().toString(),
        customerFullName = "Maestro Woke",
        equipmentType = "Лыжный комплект",
        quantity = 2,
        pricePerUnit = 13355.0,
        discount = 10.0,
        paymentMethod = "Кредитная карта"
    )

    val file = generatePurchaseFile(purchase)
    println("Файл сгенерирован: ${file.absolutePath}")
}
