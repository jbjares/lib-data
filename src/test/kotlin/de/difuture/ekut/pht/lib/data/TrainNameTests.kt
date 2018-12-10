package de.difuture.ekut.pht.lib.data

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals

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
    fun `repr of TrainName is same as repr with quotes`() {
        with(jacksonObjectMapper()) {
            trainIds.forEach {
                assertEquals(writeValueAsString(it), TrainName.from(it).repr.quoted())
            }
        }
    }

    @Test(expected = IllegalArgumentException::class)
    fun `illegal Strings cannot be turned into Train Names`() {
            illegalTrainNames.forEach {
                TrainName.from(it)
            }
        }
}
