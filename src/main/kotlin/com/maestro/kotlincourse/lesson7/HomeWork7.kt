fun main() {

    // Прямой Диапазон
    // 1. Вывод чисел от 1 до 5

    for (i in 1..5) {
        println(i)
    }

    // 2. Вывод четных чисел от 1 до 10

    for (i in 1..10) {
        if (i % 2 == 0) {
            println(i)
        }
    }

    // Обратный Диапазон
    // 3. Вывод чисел от 5 до 1

    for (i in 5 downTo 1) {
        println(i)
    }

    // 4. Вывод чисел от 10 до 1 с шагом 2

    for (i in 10 downTo 1 step 2) {
        println(i)
    }

    // С Шагом (step)
    // 5. Вывод чисел от 1 до 9 с шагом 2

    for (i in 1..9 step 2) {
        println(i)
    }

    // 6. Вывод каждого третьего числа в диапазоне от 1 до 20

    for (i in 1..20 step 3) {
        println(i)
    }

    // Использование До (until)
    // 7. Вывод чисел от 1 до 9 (9 не включается)

    for (i in 1 until 9) {
        println(i)
    }

    // 8. Вывод чисел от 3 до 15, не включая 15

    for (i in 3 until 15) {
        println(i)
    }

    // Задания для Цикла while
    // Цикл while
    // 9. Вывод квадратов чисел от 1 до 5

    var i = 1
    while (i <= 5) {
        println(i * i)
        i++
    }

    // 10. Уменьшение числа от 10 до 5

    var j = 10
    while (j >= 5) {
        println(j)
        j--
    }

    // Цикл do...while
    // 11. Вывод чисел от 5 до 1

    var k = 5
    do {
        println(k)
        k--
    } while (k > 0)

    // 12. Повторение цикла, пока счетчик меньше 10, начиная с 5

    var l = 5
    do {
        println(l)
        l++
    } while (l < 10)

    // Задания для Прерывания и Пропуска Итерации
    // Использование break
    // 13. Цикл for от 1 до 10, прерывание при достижении 6

    for (i in 1..10) {
        if (i == 6) break
        println(i)
    }

    // 14. Бесконечный цикл while, прерывание при достижении 10

    var m = 1
    while (true) {
        println(m)
        if (m == 10) break
        m++
    }

    // Использование continue
    // 15. Цикл for от 1 до 10, пропуск четных чисел

    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }

    // 16. Цикл while, пропуск чисел, кратных 3

    var n = 1
    while (n <= 10) {
        if (n % 3 == 0) {
            n++
            continue
        }
        println(n)
        n++
    }
}
