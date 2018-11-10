package de.difuture.ekut.pht.lib.data

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrainIdTests {

    private val trainIds = listOf(
            "train_iris",
            "train_dummy"
    )

    private fun String.quoted() = "\"$this\""

    @Test
    fun `repr of trainID is same as repr with quotes`() {

        with(jacksonObjectMapper()) {

            trainIds.forEach {
                assertEquals(writeValueAsString(it), TrainId.from(it).repr.quoted())
            }
        }
    }
}
