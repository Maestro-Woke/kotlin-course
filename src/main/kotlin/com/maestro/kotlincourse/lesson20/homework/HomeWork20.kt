package com.maestro.com.maestro.kotlincourse.lesson20.homework

import java.io.InputStream

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

// Абстрактные классы для устройств
abstract class Refrigerator : Powerable, TemperatureRegulatable, Openable
abstract class WashingMachine : Powerable, TemperatureRegulatable, WaterContainer, Drainable, Programmable
abstract class SmartLamp : Powerable, LightEmitting
abstract class ElectronicClock : Powerable, Timable, BatteryOperated
abstract class RobotVacuum : Powerable, Movable, Rechargeable, Cleanable
abstract class MechanicalClock : Mechanical
abstract class Flashlight : Powerable, LightEmitting
abstract class CoffeeMachine : Powerable, TemperatureRegulatable, WaterContainer, Programmable
abstract class SmartSpeaker : Powerable, SoundEmitting, Programmable

// Абстрактный класс для включаемого оборудования
abstract class PowerableDevice : Powerable {
    var isPoweredOn: Boolean = false

    override fun powerOn() {
        isPoweredOn = true
        println("Device is powered on.")
    }

    override fun powerOff() {
        isPoweredOn = false
        println("Device is powered off.")
    }
}

// Абстрактный класс для программируемого оборудования
abstract class ProgrammableDevice : PowerableDevice(), Programmable {
    var currentProgram: String? = null

    override fun programAction(action: String) {
        if (isPoweredOn) {
            currentProgram = action
            println("Program action set: $action")
        } else {
            println("Cannot set program action. Device is off.")
        }
    }

    override fun execute() {
        if (isPoweredOn && currentProgram != null) {
            println("Executing program action: $currentProgram")
        } else {
            println("Cannot execute program. Device is off or no program set.")
        }
    }
}

// Абстрактный класс оборудования с температурным и открывающимся функционалом
abstract class TemperatureControlledDevice : ProgrammableDevice(), TemperatureRegulatable, Openable {
    var currentTemperature: Int = 0

    override fun setTemperature(temp: Int) {
        if (isPoweredOn) {
            currentTemperature = temp
            println("Temperature set to: $temp°C")
        } else {
            println("Cannot set temperature. Device is off.")
        }
    }

    override fun open() {
        println("Device is opened.")
    }

    override fun close() {
        println("Device is closed.")
    }
}

// Конкретные классы устройств
class RealRefrigerator : TemperatureControlledDevice() {
    override val maxTemperature: Int = 5

    init {
        println("Refrigerator created")
    }
}

class RealWashingMachine : TemperatureControlledDevice(), WaterContainer, Drainable {
    override val maxTemperature: Int = 90
    override val capacity: Int = 50

    override fun fillWater(amount: Int) {
        println("Filling water: $amount liters")
    }

    override fun getWater(amount: Int) {
        println("Using water: $amount liters")
    }

    override fun connectToDrain() {
        println("Drain connected")
    }

    override fun drain() {
        println("Draining water")
    }
}

class RealKettle : TemperatureControlledDevice() {
    override val maxTemperature: Int = 100

    init {
        println("Kettle created")
    }
}

class RealOven : TemperatureControlledDevice() {
    override val maxTemperature: Int = 250

    init {
        println("Oven created")
    }
}

// Тестирование работы устройств
fun main() {
    val refrigerator = RealRefrigerator()
    refrigerator.powerOn()
    refrigerator.setTemperature(3)
    refrigerator.open()
    refrigerator.close()
    refrigerator.powerOff()

    val washingMachine = RealWashingMachine()
    washingMachine.powerOn()
    washingMachine.programAction("Quick Wash")
    washingMachine.execute()
    washingMachine.setTemperature(60)
    washingMachine.fillWater(30)
    washingMachine.drain()
    washingMachine.powerOff()

    val kettle = RealKettle()
    kettle.powerOn()
    kettle.setTemperature(90)
    kettle.powerOff()

    val oven = RealOven()
    oven.powerOn()
    oven.setTemperature(180)
    oven.powerOff()
}