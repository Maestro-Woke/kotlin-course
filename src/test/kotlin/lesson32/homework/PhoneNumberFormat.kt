package lesson32.homework

import com.maestro.com.maestro.kotlincourse.lesson32.homework.PhoneNumberFormatter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PhoneNumberFormatterTest {

    private val formatter = PhoneNumberFormatter()

    companion object {
        @JvmStatic
        fun validPhoneNumbers(): Stream<Arguments> = Stream.of(
            Arguments.of("8 (922) 941-11-11", "+7 (922) 941-11-11"),
            Arguments.of("79229411111", "+7 (922) 941-11-11"),
            Arguments.of("+7 922 941 11 11", "+7 (922) 941-11-11"),
            Arguments.of("9229411111", "+7 (922) 941-11-11"),
            Arguments.of("abc +7 922 941 11 11", "+7 (922) 941-11-11")
        )

        @JvmStatic
        fun invalidPhoneNumbers(): Stream<Arguments> = Stream.of(
            Arguments.of("12345"),
            Arguments.of("+1 (922) 941-11-11"),
            Arguments.of("abcdefghijk"),
            Arguments.of("11111111111"),
            Arguments.of("7 800 555 35 35")
        )
    }

    @ParameterizedTest
    @MethodSource("validPhoneNumbers")
    fun `should format valid phone numbers`(input: String, expected: String) {
        val result = formatter.formatPhoneNumber(input)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("invalidPhoneNumbers")
    fun `should throw exception for invalid phone numbers`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            formatter.formatPhoneNumber(input)
        }
    }
}