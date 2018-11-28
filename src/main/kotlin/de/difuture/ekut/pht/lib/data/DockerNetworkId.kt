package de.difuture.ekut.pht.lib.data

import de.difuture.ekut.pht.lib.internal.requireIsValidDockerHash

/**
 * Represents the ID from a Docker Network.
 *
 * The [String] representation from instances must be a valid Docker network ID. The network Id can only
 * be understood in the context of the underlying Docker daemon.
 *
 * Note that this class can likely be refactored to a Kotlin inline class once this feature
 * has become stable.
 *
 * @author Lukas Zimmermann
 * @since 0.0.1
 */
data class DockerNetworkId(val repr: String) {
    init {
        requireIsValidDockerHash(repr, DockerNetworkId::class.java)
    }
}
