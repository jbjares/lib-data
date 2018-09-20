package de.difuture.ekut.pht.lib.data

import org.junit.Assert
import java.util.Random

/**
 *  IDs that should be valid and have no sha256: prefix
 */
private val noPrefixIds = listOf(
        "a8c94ff83800",
        "0",
        "a",
        "nd632dw82e",
        "ababjhdt2",
        "51f9a1145165",
        "4e85772126c2",
        "74b5007d50ab",
        "48e0cda65fc9",
        "c5005ae06992",
        "d42c5d32fbeb",
        "8166239ca3b3",
        "196d12cf6ab1",
        "196d12cf6ab1",
        "efc483abdcc1",
        "efc483abdcc1",
        "5e35105718d5",
        "5c2e49cfd3c6",
        "940e677eea8d",
        "89a083358f3a",
        "c09547a0989a",
        "1a3f90c2ae47",
        "fbd89fa9d331",
        "ee05fd641832",
        "2a649da9add5",
        "67ebcfc41df0",
        "0bb4ddaeb6c5",
        "1fa511a83703",
        "c9f91304e512",
        "96d40cae7835",
        "395cc36c043e",
        "bb9c5d258bfc",
        "c5f07f36919f",
        "3f6e2fa1f452",
        "21e0503443c6",
        "a45e613c2267",
        "86e7117e43fd",
        "1bbf5ec86934",
        "c5f320fdf5c0",
        "3b16546bfe96",
        "59eb2f01533f",
        "af1d161b5361",
        "ce708bbffcba",
        "3ced40c0533a",
        "b659344f2f3f",
        "f1cb46627094",
        "ba8e7f82097f",
        "f21dd6c17811",
        "b2d2f7a041fe",
        "3b0e0f777bfc",
        "ac00d675847b",
        "8c4e049170f6",
        "ed27a20ea942",
        "dc0d76160f50",
        "b25d2c11d8c5",
        "9c3ce1306ae9",
        "6b39c189195b",
        "166195ec64fd",
        "5b6e2ebd3888",
        "d469a4440c7c",
        "535ca4219eb3",
        "070a9f02cf37",
        "e9caa8aff17b",
        "391baa6cbc74",
        "a568adc61965",
        "59e9c4dc4734",
        "b1b07966a2c9",
        "5e8e334e6c23",
        "78417df42da5",
        "f7e696f13da4",
        "f242ba7bbae8",
        "81e737f7fd92",
        "8b5d4f5152af",
        "8b5d4f5152af",
        "8b5d4f5152af",
        "8b5d4f5152af",
        "8b5d4f5152af",
        "8b5d4f5152af",
        "8b5d4f5152af",
        "8b5d4f5152af",
        "8b5d4f5152af",
        "8b5d4f5152af",
        "fe84bcdd2645",
        "ba096a433be5",
        "2f5974b3f4d4",
        "421d8dbea90e",
        "0f6746d58c47",
        "5df4f9af771f",
        "02adb3772067",
        "a0a6dc418822",
        "3875af4c8ec1",
        "fc99f9bf7d3c",
        "5e5a59788e34",
        "184356db7df7",
        "b2b03e9146e1",
        "11cd0b38bc3c",
        "889248300b3f",
        "a6e48607a2c6",
        "527073eb32d1",
        "93631b528e67",
        "0a41f2b11cd3",
        "7871c865c248",
        "d6fbfb7c4fdf",
        "767aa7f208ff",
        "7217cfe7d259",
        "cc886a7105ff",
        "6c4c4d39ba74",
        "eed0ae537ae5",
        "d35ae1d9a2d6",
        "7185a739be82",
        "61454fb938e9",
        "f4349a34ec6e",
        "735dcb999c3",
        "89c7f02f4847",
        "59a657bd64e2",
        "57d29d21468f",
        "3477e0a7f420",
        "faff7a7fc33d",
        "54e7979e3ae7",
        "9f217d4878b5",
        "2e18c4fecf79",
        "9056b832f3a4",
        "e4e6cede62fb",
        "bb3a64492373",
        "c9a23709b452",
        "7d96bb355ed0",
        "0750d6b2574e",
        "5fc9dcd5e2a5",
        "aced5e1e7f25",
        "5f8f875b0016",
        "786a368b7e9f",
        "957903cb918b",
        "eeaf66675b47",
        "73ac1ac5846a",
        "fc4d16e87e59",
        "3ae35dfc9ec5",
        "46a3af839c3d",
        "0c35e2fba2d2",
        "83435a40c6fa",
        "8bdd2b059399",
        "5e52032e21e7",
        "eb1e72a4c334",
        "9feaa84c31c7",
        "c0d7f140b409",
        "2ca45ba37205",
        "1a1be7da3ed1",
        "9744607dcd17",
        "510bc4c3c12b",
        "75593b4c882f"
)

private fun withPrefix(id: String, prefix: Boolean) = if (prefix) "sha256:$id" else id

internal fun assertAllEqual(wrap: (String) -> String) = { addPrefix: Boolean ->

    noPrefixIds.forEach {
        val item = withPrefix(it, addPrefix)
        Assert.assertEquals(item, wrap(item))
    }
}

private fun String.Companion.random(random: Random): String {

    val source = "abcdefghijklmnopqrtsuvwxyz0123456789"
    val ls = List(random.nextInt(100)) { source[random.nextInt(source.length)] }
    return ls.joinToString("")
}

internal fun assertAllEqualDockerContainerOutput(addPrefix: Boolean) {

    val random = Random()

    noPrefixIds.forEach {

        val id = DockerContainerId(withPrefix(it, addPrefix))
        val exitCode = random.nextInt()
        val stdout = String.random(random)
        val stderr = String.random(random)

        with(DockerContainerOutput(id, exitCode, stdout, stderr)) {

            Assert.assertEquals(this.containerId, id)
            Assert.assertEquals(this.exitCode, exitCode)
            Assert.assertEquals(this.stdout, stdout)
            Assert.assertEquals(this.stderr, stderr)
        }
    }
}

internal const val invalidID = "   -"
internal const val EMPTY = ""