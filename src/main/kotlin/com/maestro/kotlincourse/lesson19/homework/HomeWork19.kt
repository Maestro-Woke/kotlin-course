package com.maestro.com.maestro.kotlincourse.lesson19.homework

class GameMachine(
    val color: String,                      // цвет
    val model: String,                      // модель
    private var isPoweredOn: Boolean = false,  // включен
    private var isOSLoaded: Boolean = false,   // ОС загружена
    private val availableGames: List<String>,  // список доступных игр
    val hasJoystick: Boolean,               // наличие джойстика
    private var earningsBalance: Double = 0.0, // баланс вырученных средств
    val owner: String,                      // владелец
    val supportPhone: String                // телефон поддержки
) {
    // Метод включения игрового автомата (публичный)
    fun powerOn() {
        if (!isPoweredOn) {
            isPoweredOn = true
            loadOS()  // Автоматически загружаем ОС при включении
            println("Игровой автомат включен2.")
        }
    }

    // Метод выключения игрового автомата (публичный)
    fun powerOff() {
        if (isPoweredOn) {
            shutdownOS()  // Автоматически завершаем работу ОС при выключении
            isPoweredOn = false
            println("Игровой автомат выключен.")
        }
    }

    // Метод для показа списка игр (публичный)
    fun showGames() {
        println("Доступные игры: ${availableGames.joinToString(", ")}")
    }

    // Метод для запуска игры (публичный)
    fun startGame(game: String) {
        if (isOSLoaded && availableGames.contains(game)) {
            println("Запуск игры: $game")
        } else {
            println("Невозможно запустить игру.")
        }
    }

    // Метод для оплаты игрового сеанса (публичный)
    fun payForSession(amount: Double) {
        earningsBalance += amount
        println("Сеанс оплачен. Баланс выручки: $earningsBalance")
    }

    // Метод для выплаты выигрыша (публичный)
    fun payOutWinnings(amount: Double): Boolean {
        return if (earningsBalance >= amount) {
            earningsBalance -= amount
            println("Выплачен выигрыш: $amount")
            true
        } else {
            println("Недостаточно средств для выплаты выигрыша.")
            false
        }
    }

    // Приватный метод для загрузки ОС
    private fun loadOS() {
        if (isPoweredOn && !isOSLoaded) {
            isOSLoaded = true
            println("Операционная система загружена.")
        }
    }

    // Приватный метод для завершения работы ОС
    private fun shutdownOS() {
        if (isOSLoaded) {
            isOSLoaded = false
            println("Операционная система завершила работу.")
        }
    }

    // Приватный метод для открытия сейфа и выдачи наличных
    private fun openSafeAndWithdraw(amount: Double): Boolean {
        return if (earningsBalance >= amount) {
            earningsBalance -= amount
            println("Выдано $amount из сейфа. Остаток: $earningsBalance")
            true
        } else {
            println("Недостаточно средств в сейфе.")
            false
        }
    }
}

abstract class BaseClass(
    private val privateVal: String, // Это поле приватное и не доступно в main() напрямую. Однако оно доступно в ChildrenClass через вызов getAll(), который возвращает его значение.
    protected val protectedVal: String, // Поле с модификатором protected, доступно только в наследниках и классе BaseClass.
    val publicVal: String // Публичное поле, доступно всем, включая main().
) {

    var publicField = "измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "измени меня из функции main() через сеттер в наследнике"
    private var privateField = "добавь сеттер чтобы изменить меня из main()"

    fun getAll(): String {
        // Эта функция доступна в main() благодаря публичному модификатору доступа, что позволяет выводить значения полей.
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass
    private class PrivateClass
}

class ChildrenClass(
    val privateVal: String, // Доступен в main(), так как объявлен как public в конструкторе, а не как поле класса.
    protectedVal: String,
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
}