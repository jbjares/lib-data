package de.difuture.ekut.pht.lib.data

import org.junit.Assert
import org.junit.Test

class ExtensionTests {

    @Test
    fun ensure_trailing() {

        Assert.assertEquals("foo/", "foo/".ensureTrailingSlash())
        Assert.assertEquals("foo/", "foo".ensureTrailingSlash())
        Assert.assertEquals("/", "/".ensureTrailingSlash())
        Assert.assertEquals("/", "".ensureTrailingSlash())
    }

    @Test
    fun to_key_value_list() {

        Assert.assertEquals(listOf("foo=bar"), mapOf("foo" to "bar").asKeyValueList())
        Assert.assertEquals(listOf("foo?bar"), mapOf("foo" to "bar").asKeyValueList('?'))
        Assert.assertEquals(listOf("foo=bar "), mapOf("foo" to "bar ").asKeyValueList(trim = false))
        Assert.assertEquals(listOf("foo ?bar"), mapOf("foo " to "bar").asKeyValueList('?', trim = false))
        Assert.assertEquals(emptyList<String>(), emptyMap<String, String>().asKeyValueList())
    }
}
