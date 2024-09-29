/*Создайте функцию, которая будет анализировать входящие фразы и применять к ним различные преобразования, делая текст более ироничным или забавным. Функция должна уметь распознавать ключевые слова или условия и соответственно изменять фразу.*/
fun makefraze(fraza: String): String {
    var result = fraza

    if (fraza.contains("невозможно", ignoreCase = true)) {
        result = result.replace("невозможно", "совершенно точно возможно, просто требует времени")
    }
    if (fraza.startsWith("Я не уверен", ignoreCase = true)) {
        result += ", но моя интуиция говорит об обратном"
    }
    if (fraza.contains("катастрофа", ignoreCase = true)) {
        result = result.replace("катастрофа", "интересное событие")
    }
    if (fraza.endsWith("без проблем", ignoreCase = true)) {
        result = result.replace("без проблем", "с парой интересных вызовов на пути")
    }
    if (!fraza.contains(" ") && fraza.isNotEmpty()) {
        result = "Иногда, $fraza, но не всегда"
    }

    return result
}

fun main() {
    val phrases = listOf(
        "Это просто невозможно!",
        "Я не уверен, что смогу прийти завтра.",
        "Эта ситуация — катастрофа.",
        "Моя работа завершена без проблем.",
        "Победа",
        "Я не уверен, что смогу исправить это.",
        "Это невозможно сделать в срок.",
        "Этот проект завершен без проблем.",
        "Катастрофа с доставкой!",
        "Вдохновение"
    )

    for (phrase in phrases) {
        println(makefraze(phrase))
    }
}


/* fun main() {
     Задание 1 - Извлечение даты из строки лога
    val log = "Пользователь вошел в систему -> 2021-12-01 09:48:23"
    val date = log.split("->")[1].trim()  
    println(date) */

    /* Задание 2 - Маскирование личных данных (номер карты)
    val cardNumber = "7777 7777 7777 7777"
    val maskedCard = "**** **** **** " + cardNumber.takeLast(4)
    println(maskedCard) */

    /* Задание 3: Форматирование электронной почты
    val email = "username@example.com"
    val formattedEmail = email.replace("@", " [at] ").replace(".", " [dot] ")
    println(formattedEmail)  */

    /* Задание 4 - Извлечение имени файла из пути
    val filePath = "C:/Пользователи/Документы/report.txt"
    val fileName = filePath.substringAfterLast("/")
    println(fileName) */

    // Задание 5 - Создание аббревиатуры из фразы
/*    fun main() {
        val phrase = "Объектно-ориентированное программирование"
        val words = phrase.split(" ", "-")  /
        var abbreviation = ""

        for (word in words) {
            abbreviation += word[0]
        }

        abbreviation = abbreviation.uppercase()
        println(abbreviation)
    }*/


    /* Дополнительное задание: Преобразование строки с заглавными буквами
    val text = "это пример текста"
    val capitalizedText = text.split(" ").joinToString(" ") { it.capitalize() }
    println(capitalizedText)  */

    //Дополнительное задание: Шифрование строки (меняем соседние буквы местами)
   /* class Cipher {
        fun encrypt(text: String): String {
            var paddedText = text

            if (paddedText.length % 2 != 0) {
                paddedText += " "
            }

            var encryptedText = ""

            for (i in paddedText.indices step 2) {
                encryptedText += paddedText[i + 1]
                encryptedText += paddedText[i]
            }

            return encryptedText
        }

        // Метод для дешифрования строки
        fun decrypt(text: String): String {
            var decryptedText = ""

            for (i in text.indices step 2) {
                decryptedText += text[i + 1]
                decryptedText += text[i]
            }

            return decryptedText.trim()
        }
    }

    fun main() {
        val cipher = Cipher()

        val originalText = "Kotlin"
        val encryptedText = cipher.encrypt(originalText)
        println("Зашифрованный текст: $encryptedText")

        val decryptedText = cipher.decrypt(encryptedText)
        println("Дешифрованный текст: $decryptedText")
    }*/

/* Таблица умножения */
/*fun main() {
    val size = 77

    print("    ")
    for (i in 1..size) {
        print("%4d".format(i))
    }
    println()

    println("   +" + "-".repeat(size * 4))

    for (i in 1..size) {
        print("%2d |".format(i))
        for (j in 1..size) {
            print("%4d".format(i * j))
        }
        println()
    }
}*/



