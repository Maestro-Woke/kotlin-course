package com.maestro.com.maestro.kotlincourse.lesson14

fun main() {
    // 1. Среднее время выполнения тестов
    val testTimes = mapOf("Тестик1" to 12, "Тестик2" to 8, "Тестик3" to 15)
    val averageTime = testTimes.values.average()
    println("Среднее время ожидания, пока тесты тормознут: $averageTime секунд")

    // 2. Список всех тестовых методов
    val testMeta = mapOf("Методик1" to "супер важный", "Методик2" to "неважный", "Методик3" to "крайне важный")
    val testMethods = testMeta.keys.toList()
    println("Кого тестим сегодня: $testMethods")

    // 3. Добавление нового теста и его результата
    val testResults = mutableMapOf("Тест1" to "Прошёл как по маслу", "Тест2" to "Потерпел фиаско")
    testResults["Тест3"] = "Ушёл на обед и не вернулся"
    println("Как там наши тесты: $testResults")

    // 4. Количество успешных тестов
    val successfulTestsCount = testResults.values.count { it.contains("Прошёл") }
    println("Количество тестов, которые смогли: $successfulTestsCount")

    // 5. Удаление исправленного бага
    val bugTracking = mutableMapOf(1 to "Баг, который не хотел уходить", 2 to "Упрямый баг", 3 to "Баг-перфекционист")
    bugTracking.remove(2)
    println("Баги, которые остались живы: $bugTracking")

    // 6. Сообщение о статусе проверки страницы
    val pageStatus = mapOf("http://проверка.рф" to "Все пучком", "http://ошибка.рф" to "Плак-плак, не нашёлся")
    pageStatus.forEach { (url, status) -> println("Страница $url проверена и статус такой: $status") }

    // 7. Поиск сервисов с медленным ответом
    val serviceResponseTimes = mapOf("Быстрый" to 100, "Черепаха" to 300, "Заснул на полпути" to 150)
    val threshold = 200
    val slowServices = serviceResponseTimes.filterValues { it > threshold }
    println("Эти сервисы спят на ходу (больше $threshold мс): $slowServices")

    // 8. Поиск статуса ответа для указанного endpoint
    val apiResponses = mapOf("/api/сюрприз" to "200 Йоу!", "/api/чуда_не_случилось" to "500 Ой!")
    val endpoint = "/api/тайна_за_семью_печатями"
    val responseStatus = apiResponses[endpoint] ?: "Эндпоинт скрылся в туманах"
    println("Что там на $endpoint: $responseStatus")

    // 9. Получение значения конфигурации "browserType"
    val testConfig = mapOf("browserType" to "Браузер среднего качества", "timeout" to "как повезёт")
    val browserType = testConfig["browserType"] ?: "Браузер не обнаружен, сорян"
    println("Какой браузер будем мучить: $browserType")

    // 10. Создание копии словаря и добавление новой версии
    val softwareVersions = mapOf("v1.0" to "Старичок", "v1.1" to "Неплохой")
    val updatedVersions = softwareVersions.toMutableMap().apply { put("v1.2", "Что-то новенькое") }
    println("Версии, которые не стыдно показать: $updatedVersions")

    // 11. Получение настроек для конкретной модели устройства
    val deviceSettings = mapOf("iPhone" to "Готов к тестам", "Galaxy" to "Настройки не трогать")
    val model = "Nokia 3310"
    val settings = deviceSettings[model] ?: "Настройки по умолчанию, потому что это динозавр"
    println("Настройки для $model: $settings")

    // 12. Проверка наличия кода ошибки
    val errorCodes = mapOf(404 to "Где-то потерялся", 500 to "Сломался до нельзя")
    val errorCodeToCheck = 404
    val hasError = errorCodes.containsKey(errorCodeToCheck)
    println("Нашли ли мы бедолагу с кодом $errorCodeToCheck: $hasError")

    // 13. Фильтрация сценариев по версии
    val testScenarios = mapOf("Сценарий1_v1" to "Прошёл", "Сценарий2_v2" to "Застрял", "Сценарий3_v1" to "Ушёл пить кофе")
    val version = "v1"
    val filteredScenarios = testScenarios.filterKeys { it.endsWith(version) }
    println("Сценарии для версии $version, которые выжили: $filteredScenarios")

    // 14. Проверка модулей с неудачным тестированием
    val moduleResults = mapOf("Модуль1" to "Прошёл", "Модуль2" to "Упс!", "Модуль3" to "Прошёл как по маслу")
    val hasFailedModule = moduleResults.containsValue("Упс!")
    println("Есть ли модуль, который упал с треском: $hasFailedModule")

    // 15. Добавление настроек из другого словаря
    val environmentSettings = mutableMapOf("timeout" to "100 лет")
    val newSettings = mapOf("retries" to "Бесконечность", "verbose" to "Говорит не умолкая")
    environmentSettings.putAll(newSettings)
    println("Теперь наши настройки выглядят так: $environmentSettings")

    // 16. Объединение двух неизменяемых словарей с данными о багах
    val bugs1 = mapOf(1 to "Баг один", 2 to "Баг два")
    val bugs2 = mapOf(3 to "Баг три", 4 to "Баг четыре")
    val allBugs = bugs1 + bugs2
    println("Все наши баги: $allBugs")

    // 17. Очистка изменяемого словаря с временными данными о тестах
    val tempTestData = mutableMapOf(1 to "Проверка1", 2 to "Проверка2")
    tempTestData.clear()
    println("Временные данные о тестах очищены: $tempTestData")

    // 18. Исключение пропущенных тестов из отчета
    val testReport = mapOf("Тест1" to "Прошёл", "Тест2" to "Пропущен", "Тест3" to "Упс!")
    val filteredReport = testReport.filterNot { it.value == "Пропущен" }
    println("Отчет о тестах без пропусков: $filteredReport")

    // 19. Удаление устаревших конфигураций
    val configurations = mutableMapOf("старое_название" to "не используйте", "новое_название" to "пользуйтесь")
    configurations.remove("старое_название")
    println("Конфигурации после удаления устаревшего: $configurations")

    // 20. Создание отчета о тестировании
    val testingResults = mapOf("Тест1" to "Прошёл", "Тест2" to "Упс!")
    val reportList = testingResults.map { "Test ID: ${it.key}, результат: ${it.value}" }
    println("Отчет о тестировании:\n${reportList.joinToString("\n")}")

    // 21. Преобразование изменяемого словаря в неизменяемый
    val mutableResults = mutableMapOf("Тест1" to "Прошёл", "Тест2" to "Не прошёл")
    val immutableResults = mutableResults.toMap()
    println("Неизменяемые результаты: $immutableResults")

    // 22. Замена ID тестов на их названия
    val testExecutionTimes = mapOf("1" to 30, "2" to 45)
    fun getNameById(id: String) = when (id) {
        "1" -> "Тест волшебства"
        "2" -> "Тест в тумане"
        else -> "Тест не найден"
    }
    val renamedResults = testExecutionTimes.mapKeys { getNameById(it.key) }
    println("Время выполнения тестов с новыми названиями: $renamedResults")

    // 23. Увеличение оценок производительности на 10%
    val performanceScores = mutableMapOf("v1.0" to 80, "v1.1" to 90)
    performanceScores.replaceAll { _, value -> (value * 1.1).toInt() }
    println("Оценки производительности после улучшений: $performanceScores")

    // 24. Фильтрация по ключам
    val apiEndpoints = mapOf("/api/первый" to "200 OK", "/api/второй" to "500 ERROR")
    val filteredEndpoints = apiEndpoints.filterKeys { it.contains("первый") }
    println("Эндпоинты, которые нам нужны: $filteredEndpoints")

    // 25. Подсчет результатов тестов по типу
    val resultCounts = mapOf("успешно" to 5, "неуспешно" to 2)
    val totalTests = resultCounts.values.sum()
    println("Всего тестов: $totalTests")
}
