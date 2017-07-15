package at.phatbl.swiftpm.tasks

/**
 * Prints parsed Package.swift as JSON.
 */
open class DumpPackageTask : AbstractExecTask() {
    init {
        description = "Prints parsed Package.swift as JSON."

        command = "swift package dump-package"
    }
}
