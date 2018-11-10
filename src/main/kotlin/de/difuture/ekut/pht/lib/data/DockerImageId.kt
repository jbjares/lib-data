package de.difuture.ekut.pht.lib.data

import de.difuture.ekut.pht.lib.internal.requireIsValidDockerHash

/**
 * Represents the ID from a Docker Image.
 *
 * The [String] representation from instances must be a a valid Docker image ID.
 *
 * @author Lukas Zimmermann
 * @since 0.0.1
 */
data class DockerImageId(val repr: String) {

    init {
        requireIsValidDockerHash(repr, DockerImageId::class.java)
    }
}
