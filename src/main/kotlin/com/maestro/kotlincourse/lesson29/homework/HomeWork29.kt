package com.maestro.com.maestro.kotlincourse.lesson29.homework

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal

fun main() {
    // 1. Текущая временная метка
    val currentTimestamp = Instant.now()
    println("Текущая временная метка: $currentTimestamp")

    // 2. Дата рождения
    val birthDate = LocalDate.of(2003, 2, 10)
    println("Дата рождения: $birthDate")

    // 3. Количество лет с даты рождения
    val currentDate = LocalDate.now()
    val yearsBetween = ChronoUnit.YEARS.between(birthDate, currentDate)
    println("Полных лет с даты рождения: $yearsBetween")

    // 4. Функция для форматирования Temporal
    fun formatTemporal(temporal: Temporal): String {
        return when (temporal) {
            is LocalDateTime -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            is ZonedDateTime -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"))
            is LocalDate -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            is Instant -> temporal.atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"))
            else -> "Неизвестный тип: $temporal"
        }
    }

    fun isoFormatTemporal(temporal: Temporal): String {
        return when (temporal) {
            is LocalDateTime -> temporal.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            is ZonedDateTime -> temporal.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
            is LocalDate -> temporal.format(DateTimeFormatter.ISO_DATE)
            is Instant -> DateTimeFormatter.ISO_INSTANT.format(temporal)
            else -> "Неизвестный тип: $temporal"
        }
    }

    // 5. Объекты дат и времени
    val localDateTime = LocalDateTime.of(2024, 12, 14, 10, 30, 15)
    val tbilisiTime = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Tbilisi"))
    val medellinTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/Bogota"))
    val instant = Instant.parse("2023-05-20T15:42:00Z")

    println("Время по Тбилиси (24 часа): ${formatTemporal(tbilisiTime)}")
    println("Время по Медельину (24 часа): ${formatTemporal(medellinTime)}")
    println("Форматированное локальное время: ${formatTemporal(localDateTime)}")
    println("Форматированное мгновение: ${formatTemporal(instant)}")

    // 6. Функция identifyGeneration
    fun identifyGeneration(dateOfBirth: LocalDate): String {
        val boomerStart = LocalDate.of(1946, 1, 1)
        val boomerEnd = LocalDate.of(1964, 12, 31)
        val zoomerStart = LocalDate.of(1997, 1, 1)
        val zoomerEnd = LocalDate.of(2012, 12, 31)

        return when {
            !dateOfBirth.isBefore(boomerStart) && !dateOfBirth.isAfter(boomerEnd) -> "Бумер"
            !dateOfBirth.isBefore(zoomerStart) && !dateOfBirth.isAfter(zoomerEnd) -> "Зумер"
            else -> "Не определено"
        }
    }

    println(identifyGeneration(LocalDate.of(2003, 2, 10))) // Зумер
    println(identifyGeneration(LocalDate.of(1950, 6, 15))) // Бумер
    println(identifyGeneration(LocalDate.of(1980, 8, 24))) // Не определено

    // 7. Даты и форматтер
    val date1 = LocalDate.of(2023, 2, 25)
    val date2 = LocalDate.of(2024, 2, 25)
    val formatter = DateTimeFormatter.ofPattern("MMMM dd")

    val updatedDate1 = date1.plusDays(10)
    val updatedDate2 = date2.plusDays(10)

    println("Первая дата (после добавления 10 дней): ${updatedDate1.format(formatter)}")
    println("Вторая дата (после добавления 10 дней): ${updatedDate2.format(formatter)}")
}