package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.SWIFTPM_TASK_GROUP

open class DumpPackageTask : AbstractExecTask() {
    init {
        description = "Prints parsed Package.swift as JSON"
        group = SWIFTPM_TASK_GROUP

        val command = "swift package dump-package"
        commandLine = command.split(" ")
    }
}
