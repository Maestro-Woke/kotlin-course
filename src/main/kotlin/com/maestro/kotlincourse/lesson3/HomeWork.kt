package com.maestro.kotlincourse.lesson3

import java.time.LocalDate


val event: String = "Hackathon Survival" // Название мероприятия

val eventDate: LocalDate = LocalDate.of(2024,9, 13) // Дата проведения

lateinit var eventLocation: String // Место проведения

var budgetDetails: Map<String, Float> = mapOf( // Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.
    "Экипировка" to 5330f,
    "Кейтеринг" to 3220f,
    "Другие операционные расходы" to 2700f
)

var participantCount: Int = 0 // Количество участников
    set(value) {
        field = if (value >= 0) value else 0
    }

const val duration: Int = 11 // Длительность хакатона

lateinit var supplier: Map<String, String> // Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.

var eventStatus: String = "Не " // Текущее состояние хакатона (статус)

val sponsors: List<String> = listOf("Woke", "Wine", "DSA") //Список спонсоров

var budget: Int = 7777777 // Бюджет мероприятия

var internetStatus: String? = null // Текущий уровень доступа к интернету

var logisticsInfo: String? = null // Информация о транспортировке оборудования

var teamCount: Int = 0 // Количество команд
    set(value) {
        field = if (value >= 0) value else 0
    }

val taskList: List<String> = listOf("Обновить ПК", "Выставить товары") // Перечень задач

lateinit var evcuation: String // План эвакуации

val listequipmentaccessible: List<String> = listOf("6 - ПК", "4 - ноутбука")  // Список доступного оборудования

val listequipmentfree: List<String> = listOf("2 - ПК", "2 - ноутбука") // Список свободного оборудования

lateinit var mealSchedule: String // График питания участников

val backupPlan: String = "План мероприятий на случай сбоев" // План мероприятий на случай сбоев

val judges: List<String> = listOf("Wike", "Bill") // Список экспертов и жюри

val feedbackProcedures: List<String> = listOf("56terg", "grere") // Методы и процедуры для сбора отзывов

val privacyPolicy: String = "Политика конфиденциальности" // Политика конфиденциальности

var privateFeedback: Map<String, String>? = null // Приватные отзывы участников

var currentTemperature: Float = 22.0f // Текущая температура в помещении

val networkPerformance: String = "Мониторинг и анализ производительности сети" // Мониторинг и анализ производительности сети

var lightingLevel: Float = 0.0f // Уровень освещения
    set(value){
        field = if (value in 0.0..99.9) value else 30f
    }

val eventlog: List<String> = listOf("Событие началось", "Cj,snbt pfrjyxbkjcn") // Лог событий мероприятия

var medicalSupport : Boolean = false // Доступность медицинской помощи

val securityPlans: String = "Планы и процедуры для обеспечения безопасности мероприятия" // Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.

val regNumber: String = "RKF#JNIOJ"  // Регистрационный номер мероприятия

const val maxNoise: Int = 77 // Максимальный уровень шума

var noiseAlert: Boolean = false // Индикатор превышения уровня шума

lateinit var eventFormat: String // Формат мероприятия

var freeSeats: Int  = 0 // Количество свободных мест для отдыха
    set(value){
        field = if (value > 0 ) value else 0
    }

val pressPlan: String? = null // План взаимодействия с прессой\

val detailinforasionteams: String? = null // Детальная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики прогона автоматизированных проверок.

var permisstatus: Boolean = false // Статус получения всех необходимых разрешений

var exclusiveAccess: Boolean = false // Указывает, открыт ли доступ к эксклюзивным ресурсам (например, специальному оборудованию)

val partnerList: List<String> = listOf("efefe", "wefwfw") // Список партнеров мероприятия

val eventReport: String by lazy { "Отчет, включающий фотографии, видео и отзывы" } // Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.

val prizeDistribution: String = "План распределения призов" // План распределения призов

var contactlistam: List<String> = listOf("медицинский персонал", "Другие важные службы") // Контактная информация экстренных служб, медицинского персонала и других важных служб, недоступная участникам.

val specialConditions: String = "Особые условия для участников с ограниченными возможностями" // // Особые условия для участников с ограниченными возможностями

var generalMoodParticipants: String = "Отличное" // Общее настроение участников (определяется опросами)

lateinit var detailedEventPlan: String // Подробный план хакатона

lateinit var specialGuest: String // Имя знаменитого специального гостя

const val maxCapacity: Int = 777 // Максимальное количество людей вмещает место проведения

const val standardWorkHours: Int = 7 // Стандартное количество часов для работы

val currentTemperatureroom: Float = 17.0f // Текущая температура в помещении












