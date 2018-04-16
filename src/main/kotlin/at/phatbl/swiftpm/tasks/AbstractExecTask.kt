package at.phatbl.swiftpm.tasks

import at.phatbl.shellexec.ShellExec
import at.phatbl.swiftpm.Constants.Companion.SWIFTPM_TASK_GROUP

/**
 * Base class for exec tasks.
 */
abstract class AbstractExecTask : ShellExec() {
    companion object {
        // Directories to be prepended to PATH
        const val pathAdditions = "./bin:/usr/local/bin"
    }

    init {
        group = SWIFTPM_TASK_GROUP
        prePath = pathAdditions
    }
}
