package de.difuture.ekut.pht.lib.data

/**
 * Represents the output of a Docker Container after it has been exited.
 *
 * @author Lukas Zimmermann
 * @since 0.0.1
 *
 */
data class DockerContainerOutput(

    /**
    * The ID of the container that has been started
    */
    val containerId: DockerContainerId,

    /**
     * The exit code of the exited container
     */
    val exitCode: Int,

    /**
     * Standard output of the container, represented as [String]
     *
     */
    val stdout: String,

    /**
     * Standard error of the container, represented as [String]
     */
    val stderr: String,

    /**
     * List of warnings that is potentially generated while executing the container.
     * This list is potentially empty
     */
    val warnings: List<String>
)
