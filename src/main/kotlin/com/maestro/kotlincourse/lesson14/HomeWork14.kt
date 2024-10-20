package com.maestro.com.maestro.kotlincourse.lesson14

fun main() {
    // 1. Среднее время выполнения тестов
    val testDurations = mapOf("Test1" to 5.0, "Test2" to 3.0, "Test3" to 8.0)
    val averageDuration = testDurations.values.average()
    println("Среднее время выполнения тестов: $averageDuration секунд. Время идёт, а мы продолжаем!")

    // 2. Список всех тестовых методов
    val testMetadata = mapOf("testLogin" to "Авторизация пользователя", "testLogout" to "Выход из системы")
    val testMethods = testMetadata.keys.toList()
    println("Список тестовых методов: $testMethods. Команда готова к бою!")

    // 3. Добавление нового теста
    val testResults = mutableMapOf("testA" to "Passed", "testB" to "Failed")
    testResults["testC"] = "Passed"
    println("Обновленные результаты тестов: $testResults. Новые достижения!")

    // 4. Подсчет успешных тестов
    val successfulTestsCount = testResults.values.count { it == "Passed" }
    println("Количество успешных тестов: $successfulTestsCount. Успехов становится больше!")

    // 5. Удаление исправленного бага
    val bugTracker = mutableMapOf("BUG-123" to "Open", "BUG-124" to "Fixed")
    bugTracker.remove("BUG-124")
    println("Обновленный баг-трекинг: $bugTracker. На один баг меньше!")

    // 6. Сообщение о статусе страницы
    val pageStatuses = mapOf("example.com" to 200, "test.com" to 404)
    pageStatuses.forEach { (url, status) ->
        println("Страница $url имеет статус $status. Продолжаем тестировать!")
    }

    // 7. Поиск сервисов с медленным ответом
    val serviceResponseTimes = mapOf("ServiceA" to 1200, "ServiceB" to 800)
    val slowServices = serviceResponseTimes.filter { it.value > 1000 }
    println("Сервисы с медленным ответом: $slowServices. Нужно ускоряться!")

    // 8. Поиск статуса тестирования API
    val apiResults = mapOf("endpoint1" to "200 OK", "endpoint2" to "404 Not Found")
    val apiStatus = apiResults["endpoint3"] ?: "Не протестирован"
    println("Статус API: $apiStatus. Всё ещё есть над чем работать!")

    // 9. Получение параметра "browserType"
    val config = mapOf("browserType" to "Chrome", "timeout" to "30s")
    val browserType = config["browserType"] ?: "Unknown"
    println("Тип браузера: $browserType. Главное, что он запускается!")

    // 10. Копирование словаря с версиями ПО
    val softwareVersions = mapOf("v1.0" to "Stable", "v1.1" to "Beta")
    val updatedVersions = softwareVersions + ("v2.0" to "Alpha")
    println("Обновленные версии ПО: $updatedVersions. Новинки на подходе!")

    // 11. Получение настроек для мобильного устройства
    val mobileSettings = mapOf("iPhone" to "iOS 14", "Pixel" to "Android 11")
    val deviceSettings = mobileSettings["Nokia"] ?: "Настройки по умолчанию"
    println("Настройки устройства: $deviceSettings. Делаем старое новым!")

    // 12. Проверка кода ошибки
    val errorCodes = mapOf("404" to "Not Found", "500" to "Server Error")
    val hasError = errorCodes.containsKey("404")
    println("Есть ли ошибка 404? $hasError. Ошибки нас не остановят!")

    // 13. Фильтрация тестов по версии
    val testScenarios = mapOf("Test1_v1" to "Passed", "Test2_v2" to "Failed")
    val filteredTests = testScenarios.filterKeys { it.endsWith("_v2") }
    println("Фильтрованные тесты: $filteredTests. Сосредоточимся на нужном!")

    // 14. Проверка модулей с неудачным тестированием
    val moduleResults = mapOf("Auth" to "Failed", "Payment" to "Passed")
    val hasFailedModules = moduleResults.values.contains("Failed")
    println("Есть ли неудачные модули? $hasFailedModules. Вперед к победам!")

    // 15. Добавление настроек из другого словаря
    val envSettings = mutableMapOf("env" to "Test")
    val additionalSettings = mapOf("debug" to "true")
    envSettings.putAll(additionalSettings)
    println("Обновленные настройки: $envSettings. Доводим до ума!")

    // 16. Объединение двух словарей с багами
    val bugReports1 = mapOf("BUG-001" to "Open")
    val bugReports2 = mapOf("BUG-002" to "Closed")
    val allBugReports = bugReports1 + bugReports2
    println("Все баги: $allBugReports. Двойной контроль!")

    // 17. Очистка словаря с временными данными
    val tempData = mutableMapOf("lastRun" to "2023-10-01")
    tempData.clear()
    println("Временные данные очищены. Готовы к новому запуску!")

    // 18. Исключение пропущенных тестов
    val testResultsWithSkipped = mapOf("Test1" to "Passed", "Test2" to "Skipped")
    val testsWithoutSkipped = testResultsWithSkipped.filter { it.value != "Skipped" }
    println("Результаты без пропусков: $testsWithoutSkipped. Работаем только на полную!")

    // 19. Удаление устаревших конфигураций
    val configs = mutableMapOf("oldConfig" to "Legacy", "newConfig" to "Current")
    configs.remove("oldConfig")
    println("Устаревшие конфигурации удалены. Только новое и лучшее!")

    // 20. Преобразование результатов тестирования в отчет
    val formattedResults = testResults.map { (testId, result) -> "$testId: $result" }
    println("Отчет о тестировании: $formattedResults. Всё разложено по полочкам!")

    // 21. Преобразование словаря в неизменяемый
    val archivedResults = testResults.toMap()
    println("Результаты заархивированы. Всё под контролем!")

    // 22. Замена ID тестов на их названия
    fun getNameById(id: String) = "TestName_$id"
    val namedTests = testDurations.mapKeys { getNameById(it.key) }
    println("Тесты с именами: $namedTests. Каждому тесту — своё имя!")

    // 23. Увеличение оценки производительности
    val performanceRatings = mapOf("v1" to 85, "v2" to 90)
    val adjustedRatings = performanceRatings.mapValues { it.value * 1.1 }
    println("Увеличенные оценки производительности: $adjustedRatings. Растём над собой!")

    // 24. Проверка на пустоту словаря с ошибками
    val compilationErrors = emptyMap<String, String>()
    val isCompilationErrorFree = compilationErrors.isEmpty()
    println("Ошибки компиляции отсутствуют? $isCompilationErrorFree. Чистый код!")

    // 25. Проверка на непустоту результатов нагрузочного тестирования
    val loadTestResults = mapOf("LoadTest1" to "Passed")
    val isLoadTestPresent = loadTestResults.isNotEmpty()
    println("Результаты нагрузочного тестирования имеются? $isLoadTestPresent. Всё идёт по плану!")

    // 26. Проверка успешного прохождения всех тестов
    val allTestsPassed = testResults.values.all { it == "Passed" }
    println("Все тесты прошли успешно? $allTestsPassed. Отлично сработано!")

    // 27. Наличие хотя бы одной ошибки в тестах
    val containsErrors = testResults.values.any { it == "Failed" }
    println("Есть ли ошибки? $containsErrors. Всегда есть, куда расти!")

    // 28. Фильтрация тестов по ключевому слову "optional"
    val optionalTests = testResults.filterKeys { it.contains("optional") }
    println("Результаты с 'optional': $optionalTests. Опционально, но важно!")
}


