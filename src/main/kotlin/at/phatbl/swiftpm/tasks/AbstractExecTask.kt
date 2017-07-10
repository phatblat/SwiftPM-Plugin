package at.phatbl.swiftpm.tasks

import org.gradle.api.tasks.Exec

/**
 * Base class which manages the PATH environment variable.
 * Created by phatblat on 7/10/17.
 */
abstract class AbstractExecTask : Exec() {
    companion object {
        // Directories to be prepended to PATH
        const val pathAdditions = "./bin:/usr/local/bin"
    }

    init {
        environment("PATH", "${pathAdditions}:${System.getenv("PATH")}")
        doFirst {
            project.logger.info("System.env.PATH: ${System.getenv("PATH")}")
            project.logger.info("Custom PATH: ${environment["PATH"]}")
        }
    }
}