package at.phatbl.swiftpm.tasks

/**
 * Prints a summary of the modules defined by in the package.
 */
open class DescribeTask : AbstractExecTask() {
    init {
        description = "Prints a summary of the modules defined by in the package.]"
        command = "swift package describe"
    }
}
