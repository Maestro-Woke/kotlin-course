package com.maestro.com.maestro.kotlincourse.lesson31.homework

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CerealStorageImplTest {

    private lateinit var storage: CerealStorage

    @BeforeEach
    fun setUp() {
        storage = CerealStorageImpl(10f, 50f)
    }

    @Test
    fun `test addCereal`() {
        val remainder = storage.addCereal(Cereal.RICE, 15f)
        assertEquals(5f, remainder)
        assertEquals(10f, storage.getAmount(Cereal.RICE))
    }

    @Test
    fun `test getCereal`() {
        storage.addCereal(Cereal.BUCKWHEAT, 10f)
        val taken = storage.getCereal(Cereal.BUCKWHEAT, 7f)
        assertEquals(7f, taken)
        assertEquals(3f, storage.getAmount(Cereal.BUCKWHEAT))
    }

    @Test
    fun `test removeContainer`() {
        storage.addCereal(Cereal.RICE, 10f)
        storage.getCereal(Cereal.RICE, 10f)
        assertTrue(storage.removeContainer(Cereal.RICE))
    }
}