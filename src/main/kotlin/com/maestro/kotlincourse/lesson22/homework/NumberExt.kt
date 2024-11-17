package com.maestro.com.maestro.kotlincourse.lesson22.homework

import kotlin.math.absoluteValue

fun Number.isCloseTo(other: Number, maxDeviation: Number): Boolean {
    val difference = (this.toDouble() - other.toDouble()).absoluteValue
    return difference <= maxDeviation.toDouble()
}