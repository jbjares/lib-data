package de.difuture.ekut.pht.lib.data

import de.difuture.ekut.pht.lib.extensions.asKeyValueList
import de.difuture.ekut.pht.lib.extensions.ensureTrailingSlash
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExtensionTests {

    @Test
    fun ensure_trailing() {
        assertEquals("foo/", "foo/".ensureTrailingSlash())
        assertEquals("foo/", "foo".ensureTrailingSlash())
        assertEquals("/", "/".ensureTrailingSlash())
        assertEquals("/", "".ensureTrailingSlash())
    }

    @Test
    fun to_key_value_list() {

        assertEquals(listOf("foo=bar"), mapOf("foo" to "bar").asKeyValueList())
        assertEquals(listOf("foo?bar"), mapOf("foo" to "bar").asKeyValueList('?'))
        assertEquals(listOf("foo=bar "), mapOf("foo" to "bar ").asKeyValueList(trim = false))
        assertEquals(listOf("foo ?bar"), mapOf("foo " to "bar").asKeyValueList('?', trim = false))
        assertEquals(emptyList<String>(), emptyMap<String, String>().asKeyValueList())
    }
}
