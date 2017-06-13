package at.phatbl.swiftpm.tasks

import org.gradle.api.tasks.Exec

/**
 * Base class which manages the PATH environment variable.
 * Created by phatblat on 6/13/17.
 */
abstract class AbstractExecTask extends Exec {
    // Directories to be prepended to PATH
    private String pathAdditions = "./bin:/usr/local/bin"

    AbstractExecTask() {
        environment 'PATH', "${pathAdditions}:${System.env.PATH}"
        doFirst {
            project.logger.info "System.env.PATH: ${System.env.PATH}"
            project.logger.info "Custom PATH: ${environment['PATH']}"
        }
    }
}
