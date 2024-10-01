package com.maestro.com.maestro.kotlincourse.game

import kotlin.random.Random

data class Character(val name: String, var health: Int, var attackPower: Int, var armor: Int = 0) {
    fun isAlive(): Boolean {
        return health > 0
    }

    fun effectiveAttackPower(): Int {
        return attackPower - armor
    }
}

data class Equipment(val name: String, val attackBonus: Int, val armorBonus: Int)

data class Item(val name: String, val healAmount: Int)

fun main() {
    println("Witamy w memowym świecie RPG! Przygotuj się na epickie przygody!")

    val playerName = getPlayerName()
    val player = Character(playerName, 100, 20)

    println("Twoja postać: ${player.name} z życiem ${player.health} i mocą ataku ${player.attackPower}. Let's go!")

    val equipmentList = mutableListOf(
        Equipment("Mega Miecz", attackBonus = 5, armorBonus = 0),
        Equipment("Epicki Tarcza", attackBonus = 0, armorBonus = 3),
        Equipment("Snajper Łuk", attackBonus = 3, armorBonus = 0),
        Equipment("Złota Zbroja", attackBonus = 0, armorBonus = 5)
    )

    equipEquipment(player, equipmentList)

    val items = mutableListOf(
        Item("Mikstura Zdrowia", healAmount = 20),
        Item("Mikstura Mana", healAmount = 15)
    )

    val enemies = listOf(
        Character("Straszny Królik", 50, 10),
        Character("Szef Nietoperzy", 40, 8),
        Character("Szaleniec Jednorożec", 60, 12)
    )

    val bosses = listOf(
        Character("Smok OGIEŃ", 100, 25),
        Character("Władca Ciemności", 80, 20)
    )

    while (true) {
        println("\nGdzie chcesz iść?")
        println("1. Lewo (Bądź ostrożny, tam mogą być pokemony!)")
        println("2. Prawo (Może znajdziesz coś do jedzenia?)")
        println("3. W górę (Niebo wygląda podejrzanie!)")
        println("4. W dół (Zdecydowanie nie przypomina to IKEA!)")

        when (readLine()) {
            "1" -> encounter(player, enemies, items, bosses)
            "2" -> encounter(player, enemies, items, bosses)
            "3" -> encounter(player, enemies, items, bosses)
            "4" -> encounter(player, enemies, items, bosses)
            else -> {
                println("Nieprawidłowy wybór. Próbuj dalej, nie daj się pokonać!")
                continue
            }
        }

        if (!player.isAlive()) {
            println("Przegrana! Zgon jak w Dark Souls. Skończono grę.")
            return
        }
    }
}

fun getPlayerName(): String {
    println("Podaj swoje epickie imię:")
    return readLine() ?: "Anonimowy Wojownik"
}

fun equipEquipment(player: Character, equipmentList: MutableList<Equipment>): Equipment {
    while (true) {
        println("\nDostępne ekwipunki:")
        equipmentList.forEachIndexed { index, equipment ->
            println("${index + 1}. ${equipment.name} (Siła ataku +${equipment.attackBonus}, Pancerz +${equipment.armorBonus})")
        }
        println("Wybierz numer sprzętu do założenia (Nie możesz zmienić zdania!):")

        val input = readLine()?.toIntOrNull()

        if (input != null && input in 1..equipmentList.size) {
            val selectedEquipment = equipmentList[input - 1]
            player.attackPower += selectedEquipment.attackBonus
            player.armor += selectedEquipment.armorBonus
            println("Założyłeś ${selectedEquipment.name}. Teraz jesteś prawdziwym wojownikiem!")
            return selectedEquipment
        } else {
            println("Nieprawidłowy wybór. Próbuj dalej! To nie jest kasyno!")
        }
    }
}

fun encounter(player: Character, enemies: List<Character>, items: List<Item>, bosses: List<Character>) {
    val encounterType = Random.nextInt(1, 4) // 1: enemy, 2: boss, 3: chest
    when (encounterType) {
        1 -> {
            val enemy = enemies.random()
            println("Zostałeś zaatakowany przez: ${enemy.name}! O kurwa! Będzie ciężko!")
            battle(player, enemy)
        }
        2 -> {
            val boss = bosses.random()
            println("Zmierzasz do bossa: ${boss.name}! O kurwa! To będzie epickie starcie!")
            battle(player, boss)
        }
        3 -> {
            val item = items.random()
            println("Znalazłeś skrzynię z ${item.name}! Przywracasz ${item.healAmount} HP. O kurwa! To cud!")
            player.health += item.healAmount
            println("${player.name} teraz ma: ${player.health} HP. Życie jest piękne!")
        }
    }
}

fun battle(player: Character, enemy: Character) {
    while (player.isAlive() && enemy.isAlive()) {
        println("\nTwój ruch! Wybierz akcję:")
        println("1. Atak (Zadajesz ${player.effectiveAttackPower()} obrażeń. Dawaj, zrób to!)")
        println("2. Użyj mikstury (Leczenie! Nie umieraj, proszę!)")

        when (readLine()) {
            "1" -> attack(player, enemy, player.effectiveAttackPower())
            "2" -> usePotion(player)
            else -> {
                println("Zły wybór. Próbuj dalej! To nie jest gra w szachy.")
                continue
            }
        }

        if (enemy.isAlive()) {
            enemyAttack(player, enemy)
        }
    }
}

fun attack(player: Character, enemy: Character, damage: Int) {
    enemy.health -= damage
    println("${player.name} atakuje ${enemy.name} i zadaje $damage obrażeń. Prosto w ryj!")
    println("${enemy.name} pozostało życia: ${enemy.health}")
}

fun usePotion(player: Character) {
    val healAmount = 15
    player.health += healAmount
    println("${player.name} używa mikstury i przywraca $healAmount HP! O kurwa! Cudowne życie!")
    println("${player.name} teraz ma: ${player.health} HP. Wróciłeś do życia!")
}

fun enemyAttack(player: Character, enemy: Character) {
    if (player.health > 0) {
        val damage = enemy.attackPower - player.armor
        player.health -= if (damage > 0) damage else 0
        println("${enemy.name} atakuje ${player.name} i zadaje ${if (damage > 0) damage else 0} obrażeń. Auć!")
        println("${player.name} pozostało życia: ${player.health}. Trzymaj się, wojowniku!")
    }
}
