package com.maestro.com.maestro.kotlincourse.lesson32.homework

class PhoneNumberFormatter {
    fun formatPhoneNumber(input: String): String {
        val numericString = input.replace("\\D".toRegex(), "") // Убираем нечисловые символы

        when {
            numericString.length == 11 && numericString.startsWith("8") -> {
                return formatStandardPhoneNumber("+7${numericString.substring(1)}")
            }
            numericString.length == 11 && numericString.startsWith("7") -> {
                return formatStandardPhoneNumber("+$numericString")
            }
            numericString.length == 10 -> {
                if (numericString.startsWith("9")) {
                    return formatStandardPhoneNumber("+7$numericString")
                } else {
                    throw IllegalArgumentException("Неверный формат номера телефона")
                }
            }
            else -> throw IllegalArgumentException("Неверный формат номера телефона")
        }
    }

    private fun formatStandardPhoneNumber(cleanNumber: String): String {
        val areaCode = cleanNumber.substring(2, 5)
        val prefix = cleanNumber.substring(5, 8)
        val lineNumber = cleanNumber.substring(8, 10)
        val lastPart = cleanNumber.substring(10, 12)
        return "+7 ($areaCode) $prefix-$lineNumber-$lastPart"
    }
}