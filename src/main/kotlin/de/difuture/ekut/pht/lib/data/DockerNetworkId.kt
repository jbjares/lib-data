package de.difuture.ekut.pht.lib.data

/**
 * Represents the ID of a Docker Network.
 *
 * The [String] representation of instances must be a a valid Docker network ID.
 *
 * @author Lukas Zimmermann
 * @since 0.0.1
 */
data class DockerNetworkId(val repr: String) {

    init {
        requireIsValidDockerHash(repr, DockerNetworkId::class.java)
    }
}
