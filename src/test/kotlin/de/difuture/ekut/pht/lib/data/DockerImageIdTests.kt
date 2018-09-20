package de.difuture.ekut.pht.lib.data

import org.junit.Test

/**
 * Tests [DockerImageId]
 *
 * @author Lukas Zimmermann
 * @since 0.0.4
 */
class DockerImageIdTests {

    private val testIds = assertAllEqual { DockerImageId(it).repr }

    @Test
    fun valid_image_ids_no_prefix() {
        testIds(false)
    }

    @Test
    fun valid_image_ids_with_prefix() {
        testIds(true)
    }

    @Test(expected = IllegalArgumentException::class)
    fun assert_error_if_invalid_name() {
        DockerImageId(invalidID)
    }
}
