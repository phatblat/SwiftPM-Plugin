package at.phatbl.swiftpm.tasks

/**
 * Prints the version of the swift package manager.
 */
open class PMVersionTask : AbstractExecTask() {
    init {
        description = "Prints the version of SwiftPM being used."
        command = "swift package --version"
    }
}
