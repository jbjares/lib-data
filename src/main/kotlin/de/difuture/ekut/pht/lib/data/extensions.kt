package de.difuture.ekut.pht.lib.data

/**
 * Ensures that the [String] ends with the specified character.
 * The returned String will be identical to the original one
 * if the character is already present at the end of the [String]
 *
 * @param symbol The character that is to be ensured to be present
 * @return String that has the specified at its end
 *
 */
fun String.ensureTrailing(symbol: Char) = if (this.endsWith(symbol)) this else "$this$symbol"

/**
 * Ensures that the String has '/' at its end
 */
fun String.ensureTrailingSlash() = this.ensureTrailing('/')

/**
 * Maps the key-value map down to a list with the specified separator
 */
fun Map<String, String>.asKeyValueList(sep: Char = '=', trim: Boolean = true) = this.map {

    val key = if (trim) it.key.trim() else it.key
    val value = if (trim) it.value.trim() else it.value
    "$key$sep$value"
}
