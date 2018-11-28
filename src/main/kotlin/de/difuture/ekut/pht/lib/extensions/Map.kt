package de.difuture.ekut.pht.lib.extensions

/**
 * Maps the key-value map down to a list with the specified separator
 *
 * @param sep The separator to be used to separate key-value pairs
 * @param trim Whether both key and value should be trimmed before written as [String]
 *
 * @return List of key-value pairs
 */
fun Map<String, String>.asKeyValueList(sep: Char = '=', trim: Boolean = true): List<String> = this.map {

    val key = if (trim) it.key.trim() else it.key
    val value = if (trim) it.value.trim() else it.value
    "$key$sep$value"
}
