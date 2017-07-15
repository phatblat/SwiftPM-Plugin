package at.phatbl.swiftpm.tasks

/**
 * Deletes build artifacts.
 */
open class CleanTask : AbstractExecTask() {
    init {
        description = "Deletes build artifacts."
        command = "swift package clean"
    }
}
