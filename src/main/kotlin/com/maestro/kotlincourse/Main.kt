package com.maestro.com.maestro.kotlincourse


import kotlinx.coroutines.*
import kotlin.math.*
import kotlin.random.Random

// Класс для представления узлов графа
class Node(val id: Int) {
    val neighbors = mutableListOf<Node>()
    val distances = mutableMapOf<Node, Double>()

    fun addNeighbor(node: Node, distance: Double) {
        neighbors.add(node)
        distances[node] = distance
    }
}

// Класс для представления графа
class Graph(val nodes: List<Node>) {
    fun dijkstra(startNode: Node): Map<Node, Double> {
        val distances = mutableMapOf<Node, Double>().withDefault { Double.POSITIVE_INFINITY }
        distances[startNode] = 0.0
        val unvisited = nodes.toMutableSet()

        while (unvisited.isNotEmpty()) {
            val current = unvisited.minByOrNull { distances.getValue(it) } ?: break
            unvisited.remove(current)

            for (neighbor in current.neighbors) {
                val newDist = distances.getValue(current) + current.distances[neighbor]!!
                if (newDist < distances.getValue(neighbor)) {
                    distances[neighbor] = newDist
                }
            }
        }
        return distances
    }

    // Примитивный алгоритм кластеризации (по соседям)
    fun clusterNodes(): List<Set<Node>> {
        val clusters = mutableListOf<Set<Node>>()
        val visited = mutableSetOf<Node>()

        for (node in nodes) {
            if (node !in visited) {
                val cluster = mutableSetOf<Node>()
                visit(node, visited, cluster)
                clusters.add(cluster)
            }
        }
        return clusters
    }

    private fun visit(node: Node, visited: MutableSet<Node>, cluster: MutableSet<Node>) {
        if (node !in visited) {
            visited.add(node)
            cluster.add(node)
            for (neighbor in node.neighbors) {
                visit(neighbor, visited, cluster)
            }
        }
    }
}

// Физическая симуляция системы тел
data class Body(
    val id: Int,
    var mass: Double,
    var position: Pair<Double, Double>,
    var velocity: Pair<Double, Double>
)

fun createBodies(numBodies: Int): List<Body> {
    return List(numBodies) {
        Body(
            id = it,
            mass = Random.nextDouble(1.0, 1000.0),
            position = Pair(Random.nextDouble(-1000.0, 1000.0), Random.nextDouble(-1000.0, 1000.0)),
            velocity = Pair(Random.nextDouble(-10.0, 10.0), Random.nextDouble(-10.0, 10.0))
        )
    }
}

// Симуляция гравитационного взаимодействия тел
suspend fun simulateGravity(bodies: List<Body>, timeStep: Double, steps: Int) {
    val G = 6.67430e-11 // Гравитационная постоянная
    repeat(steps) { step ->
        coroutineScope {
            bodies.forEach { body1 ->
                launch {
                    var forceX = 0.0
                    var forceY = 0.0
                    bodies.forEach { body2 ->
                        if (body1 != body2) {
                            val dx = body2.position.first - body1.position.first
                            val dy = body2.position.second - body1.position.second
                            val distance = sqrt(dx * dx + dy * dy) + 1e-9
                            val force = G * body1.mass * body2.mass / (distance * distance)
                            forceX += force * (dx / distance)
                            forceY += force * (dy / distance)
                        }
                    }
                    body1.velocity = Pair(
                        body1.velocity.first + forceX / body1.mass * timeStep,
                        body1.velocity.second + forceY / body1.mass * timeStep
                    )
                    body1.position = Pair(
                        body1.position.first + body1.velocity.first * timeStep,
                        body1.position.second + body1.velocity.second * timeStep
                    )
                }
            }
        }
        if (step % 100 == 0) {
            println("Шаг симуляции гравитации $step завершён")
        }
    }
}

// Генерация большого набора данных для тренировки нейронной сети
fun generateTrainingData(numSamples: Int): Array<DoubleArray> {
    return Array(numSamples) { DoubleArray(1000) { Random.nextDouble(0.0, 1.0) } }
}

// Простая нейронная сеть
class NeuralNetwork(val numInputs: Int, val numOutputs: Int) {
    val weights = Array(numOutputs) { DoubleArray(numInputs) { Random.nextDouble(-1.0, 1.0) } }

    fun feedForward(inputs: DoubleArray): Array<Double> {
        return Array(numOutputs) { i ->
            (weights[i] zip inputs).sumOf { it.first * it.second }
        }
    }
}

// Обучение нейронной сети
suspend fun trainNeuralNetwork(network: NeuralNetwork, data: Array<DoubleArray>, epochs: Int) {
    repeat(epochs) { epoch ->
        coroutineScope {
            data.forEach { sample ->
                launch {
                    network.feedForward(sample)
                }
            }
        }
        if (epoch % 10 == 0) {
            println("Эпоха $epoch завершена")
        }
    }
}

fun createGraph(numNodes: Int, numEdges: Int): Graph {
    val nodes = List(numNodes) { Node(it) }
    repeat(numEdges) {
        val node1 = nodes.random()
        val node2 = nodes.random()
        val distance = Random.nextDouble(1.0, 100.0)
        node1.addNeighbor(node2, distance)
        node2.addNeighbor(node1, distance)
    }
    return Graph(nodes)
}

fun main() = runBlocking {
    val numBodies = 100_000 // Число тел для физической симуляции
    val bodies = createBodies(numBodies)

    val numSamples = 1_000_000 // Количество данных для нейронной сети
    val trainingData = generateTrainingData(numSamples)

    val network = NeuralNetwork(numInputs = 1000, numOutputs = 100)

    val graph = createGraph(500_000, 1_000_000) // Огромный граф

    println("Начинаем параллельную симуляцию...")

    // Параллельное выполнение задач
    launch {
        simulateGravity(bodies, timeStep = 0.01, steps = 10_000)
    }

    launch {
        trainNeuralNetwork(network, trainingData, epochs = 100)
    }

    launch {
        println("Запуск поиска кратчайших путей в графе...")
        val distances = graph.dijkstra(graph.nodes.first())
        println("Кратчайшие пути рассчитаны.")
    }

    launch {
        println("Кластеризация узлов графа...")
        val clusters = graph.clusterNodes()
        println("Граф кластеризован на ${clusters.size} кластеров.")
    }

    // Ждём завершения всех задач
    delay(200_000)
    println("Все задачи завершены")
}




