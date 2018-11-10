package de.difuture.ekut.pht.lib.data

import de.difuture.ekut.pht.lib.internal.requireIsValidDockerHash

/**
 * Represents the ID from a Docker Network.
 *
 * The [String] representation from instances must be a a valid Docker network ID.
 *
 * @author Lukas Zimmermann
 * @since 0.0.1
 */
data class DockerNetworkId(val repr: String) {

    init {
        requireIsValidDockerHash(repr, DockerNetworkId::class.java)
    }
}
