package at.phatbl.swiftpm.tasks

/**
 * Resets the complete cache/build directory.
 */
// FIXME: Fails if the .build directory doesn't exist.
open class ResetTask : AbstractExecTask() {
    init {
        description = "Resets the complete cache/build directory."
        command = "swift package reset"
    }
}
