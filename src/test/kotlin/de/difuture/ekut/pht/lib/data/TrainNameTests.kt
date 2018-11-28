package de.difuture.ekut.pht.lib.data

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TrainNameTests {

    private val trainIds = listOf(
            "train_iris",
            "train_dummy"
    )

    private val illegalTrainNames = listOf(
            "",
            " ",
            "\t",
            "foobar",
            " foobar",
            "foo bar",
            "train_foo ",
            "train_foo bar"
    )

    private fun String.quoted() = "\"$this\""

    @Test
    fun `repr of trainID is same as repr with quotes`() {
        with(jacksonObjectMapper()) {
            trainIds.forEach {
                assertEquals(writeValueAsString(it), TrainName.from(it).repr.quoted())
            }
        }
    }

    @Test
    fun `illegal_strings_cannot_be_turned_into_train_names`() {
            illegalTrainNames.forEach {
                assertThrows<IllegalArgumentException> { TrainName.from(it) }
            }
        }
}
