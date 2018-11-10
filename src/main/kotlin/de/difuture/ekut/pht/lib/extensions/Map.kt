package de.difuture.ekut.pht.lib.extensions

/**
 * Maps the key-value map down to a list with the specified separator
 */
fun Map<String, String>.asKeyValueList(sep: Char = '=', trim: Boolean = true) = this.map {

    val key = if (trim) it.key.trim() else it.key
    val value = if (trim) it.value.trim() else it.value
    "$key$sep$value"
}
