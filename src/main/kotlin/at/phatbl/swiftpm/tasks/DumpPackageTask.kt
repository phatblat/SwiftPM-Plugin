package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.SWIFTPM_TASK_GROUP

// TODO: Figure out how to extend AbstractExecTask groovy class
//import at.phatbl.swiftpm.tasks.AbstractExecTask
import org.gradle.api.tasks.Exec

open class DumpPackageTask : Exec() {
    init {
        description = "Prints parsed Package.swift as JSON"
        group = SWIFTPM_TASK_GROUP

        val command = "swift package dump-package"
        commandLine = command.split(" ")
    }
}
