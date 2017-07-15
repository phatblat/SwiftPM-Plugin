package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.SWIFTPM_TASK_GROUP
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

    /**
     * String of commands to be executed by Gradle, split on space before being passed to commandLine.
     */
    var command: String = ""
        set(value) {
            field = value
            commandLine = value.split(" ")
        }

    init {
        group = SWIFTPM_TASK_GROUP

        environment("PATH", "${pathAdditions}:${System.getenv("PATH")}")
        doFirst {
            project.logger.info("System.env.PATH: ${System.getenv("PATH")}")
            project.logger.info("Custom PATH: ${environment["PATH"]}")
        }
    }
}
