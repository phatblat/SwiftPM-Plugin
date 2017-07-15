package at.phatbl.swiftpm.tasks

/**
 * Prints the version of swift.
 */
open class SwiftVersionTask : AbstractExecTask() {
    init {
        description = "Prints the version of Swift being used."
        command = "swift --version"
    }
}
