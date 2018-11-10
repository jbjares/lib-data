package de.difuture.ekut.pht.lib.data

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import de.difuture.ekut.pht.lib.internal.TrainIdDeserializer
import de.difuture.ekut.pht.lib.internal.TrainIdSerializer

/**
 * Represents the ID from a train.
 *
 * @author Lukas Zimmermann
 * @since 0.0.1
 */
@JsonSerialize(using = TrainIdSerializer::class)
@JsonDeserialize(using = TrainIdDeserializer::class)
interface TrainId {

    val repr: String

    private data class GenericTrainId(override val repr: String) : TrainId

    companion object {

        // The regex that we allow for potential values from the trainId
        // A train needs to start with the train_ prefix
        private val regex = Regex("train_[a-zA-Z](?:[a-zA-Z0-9_-]*[a-z0-9])?")

        fun from(input: String): TrainId {

            require(input.matches(regex))
            return GenericTrainId(input)
        }
    }
}
