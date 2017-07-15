package at.phatbl.swiftpm.tasks

/**
 * Prints parsed Package.swift as JSON.
 */
open class DumpPackageTask : AbstractExecTask() {
    init {
        description = "Prints parsed Package.swift as JSON."

        val command = "swift package dump-package"
        commandLine = command.split(" ")
    }
}
