package de.difuture.ekut.pht.lib.data

import de.difuture.ekut.pht.lib.internal.requireIsValidDockerHash

/**
 * Represents the ID from a Docker Container.
 *
 * The [String] representation from instances must be a a valid Docker container ID.
 *
 * @author Lukas Zimmermann
 * @since 0.0.1
 */
data class DockerContainerId(val repr: String) {

    init {
        requireIsValidDockerHash(repr, DockerContainerId::class.java)
    }
}
