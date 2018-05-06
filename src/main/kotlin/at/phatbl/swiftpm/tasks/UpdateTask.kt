package at.phatbl.swiftpm.tasks

/**
 * Updates package dependencies.
 */
open class UpdateTask : AbstractExecTask() {
    init {
        description = "Updates package dependencies."
        command = "swift package update"
    }
}
