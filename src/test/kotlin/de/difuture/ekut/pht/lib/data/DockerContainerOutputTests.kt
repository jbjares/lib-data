package de.difuture.ekut.pht.lib.data

import org.junit.Test

/**
 * Tests [DockerContainerOutput]
 *
 * @author Lukas Zimmermann
 * @since 0.0.4
 */
class DockerContainerOutputTests {

    private val testIds = assertAllEqual {
        DockerContainerOutput(
                DockerContainerId(it),
                0,
                EMPTY,
                EMPTY).containerId.repr
    }

    @Test
    fun valid_container_outputs_no_prefix() {
        testIds(false)
    }

    @Test
    fun valid_container_outputs_with_prefix() {
        testIds(true)
    }

    @Test(expected = IllegalArgumentException::class)
    fun assert_error_if_invalid_name() {
        DockerContainerOutput(DockerContainerId(invalidID), 0, EMPTY, EMPTY)
    }
}
