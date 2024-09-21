package com.maestro.com.maestro.kotlincourse.lesson6

import javax.swing.text.Document

/* Задание 1 - "Определение Сезона"
fun getSeason(month: Int) = when (month) {
    in 3..5 -> "Весна"
    in 6..8 -> "Лето"
    in 9..11 -> "Осень"
    else -> "Зима"
}*/

/* Задание 2 -  "Расчет Возраста Питомца"
fun perroHastaAñosHumanos(dogYears: Int) = if (dogYears <= 2)
    dogYears * 10.5
else
    21 + (dogYears - 2) * 4 */

/* Задание 3 - "Определение Вида Транспорта"
fun transport(routeLength: Int) = when {
    routeLength <= 1 -> "пешком"
    routeLength <= 5 -> "велосипед"
    else -> "автотранспорт"
}*/

/* Задание 4 - "Расчет Бонусных Баллов"
fun bonusPoints(purchaseAmount: Double) = if (purchaseAmount <= 1000.0)
    (purchaseAmount / 100 * 2).toInt()
else
    (1000 / 100 * 2 + (purchaseAmount - 1000) / 100 * 5).toInt()
*/

/* Задание 5 - "Определение Типа Документа"
fun documentType(document: String) = when (document) {
    "txt" -> "Текстовый документ"
    "xls", "xlsx" -> "Таблица"
    "jpg", "png" -> "Изображение"

    else -> "Неизвестный тип"
}*/

/*Задание 6 - "Конвертация Температуры"
fun convertTemperature(temperature: Double, individual: String) = if (individual == "C")
    unit == "C")
    "${value * 9/5 + 32} F"
else
    "${(value - 32) * 5/9} C"*/

/* Задание 7 - "Подбор Одежды по Погоде
fun Clothing(temperature: String) = when {
    temperature <= 0 -> "куртка и шапка"
    temperature <= 15 -> ""ветровка"
    else -> "Рекомендуется не выходить из дома"
}*/

/* Задание 8 -  "Выбор Фильма по Возрасту"
fun Movies(age: Int) = when {
    age < 12 -> "детские"
    age < 18 -> "подростковые"
    else -> "18+"
}
}*/

