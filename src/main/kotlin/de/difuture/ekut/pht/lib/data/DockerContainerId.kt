package de.difuture.ekut.pht.lib.data

/**
 * Represents the ID of a Docker Container.
 *
 * The [String] representation of instances must be a a valid Docker container ID.
 *
 * @author Lukas Zimmermann
 * @since 0.0.1
 */
data class DockerContainerId(val repr: String) {

    init {
        requireIsValidDockerHash(repr, DockerContainerId::class.java)
    }
}
