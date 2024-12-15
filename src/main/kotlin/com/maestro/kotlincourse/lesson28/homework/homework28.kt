package com.maestro.com.maestro.kotlincourse.lesson28.homework

import java.io.File

fun main() {
    // Задача 1: Создание файла
    val file1 = File("workspace/task1/example.txt")
    file1.parentFile.mkdirs()
    file1.writeText("Hello, Kotlin!")
    println("Файл создан: ${file1.exists()}")

    // Задача 2: Создание директории
    val dir2 = File("workspace/task2/testDir")
    dir2.mkdirs()
    println("Директория создана: ${dir2.isDirectory}")

    // Задача 3: Создание структуры папок
    val myDir = File("workspace/task3/structure/myDir")
    File(myDir, "subDir1").mkdirs()
    File(myDir, "subDir2").mkdirs()
    println("Структура создана: ${myDir.list()?.toList()}")

    // Задача 4: Удаление папки
    val tempDir = File("workspace/task4/temp")
    tempDir.mkdirs()
    File(tempDir, "file.txt").writeText("temp data")
    File("workspace/task4").deleteRecursively()
    println("Папка удалена: ${!File("workspace/task4").exists()}")

    // Задача 5: Чтение параметров
    val config = File("workspace/task5/config/config.txt")
    config.parentFile.mkdirs()
    config.writeText("key1=value1\nkey2=value2\nkey3=value3")
    println("Параметры: ${config.readLines().map { it.substringAfter("=") }}")

    // Задача 6: Вывод директорий и файлов
    println("Содержимое workspace:")
    File("workspace").walk().forEach { println(if (it.isDirectory) "Директория: ${it.path}" else "Файл: ${it.path}") }

    // Задача 7: Проверка README
    val readme = File("workspace/task9/docs/readme.md")
    if (!readme.exists()) readme.apply { parentFile.mkdirs(); writeText("This is a README file.") }
    println("README существует: ${readme.exists()}")

    // Задача 8: Копирование файлов
    val filesToCopy = listOf(
        "workspace/task10/data/1/4/prod/data14.mysql",
        "workspace/task10/data/2/3/prod/data23.mysql",
        "workspace/task10/data/5/2/prod/data52.mysql"
    )
    filesToCopy.forEach { File(it).apply { parentFile.mkdirs(); writeText("Data in $name") } }
    val backupDir = File("workspace/task10/backup")
    filesToCopy.forEach {
        val source = File(it)
        val destination = File(backupDir, source.relativeTo(File("workspace/task10/data")).path)
        destination.parentFile.mkdirs()
        source.copyTo(destination, overwrite = true)
    }
    println("Файлы скопированы в backup.")
}