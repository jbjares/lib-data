package de.difuture.ekut.pht.lib.data

/**
 * The regular expression for Docker Hash values. The sha256: prefix is optional.
 */
private val dockerHashRegex = Regex("(?:sha256:)?[a-z0-9]+")

internal fun requireIsValidDockerHash(input: String, clazz: Class<*>) {

    require(input.matches(dockerHashRegex)) {

        "Input String $input is not a valid Docker Hash for class: ${clazz.canonicalName}"
    }
}
