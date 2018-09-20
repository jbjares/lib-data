package de.difuture.ekut.pht.lib.data

import org.junit.Test

/**
 * Tests [DockerContainerId]
 *
 * @author Lukas Zimmermann
 * @since 0.0.4
 *
 */
class DockerContainerIdTests {

    private val testIds = assertAllEqual { DockerContainerId(it).repr }

    @Test
    fun valid_container_ids_no_prefix() {
        testIds(false)
    }

    @Test
    fun valid_container_ids_with_prefix() {
        testIds(true)
    }

    @Test(expected = IllegalArgumentException::class)
    fun assert_error_if_invalid_name() {
        DockerContainerId(invalidID)
    }
}
