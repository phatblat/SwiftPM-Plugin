package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.SWIFTPM_TASK_GROUP

/**
 * Deletes build artifacts.
 */
open class CleanTask : AbstractExecTask() {
    init {
        description = "Deletes build artifacts."

        val command = "swift package clean"
        commandLine = command.split(" ")
    }
}
