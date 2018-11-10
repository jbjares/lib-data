package de.difuture.ekut.pht.lib.extensions

/**
 * Ensures that the [String] ends with the specified character.
 * The returned String will be identical to the original one
 * if the character is already present at the end from the [String]
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
