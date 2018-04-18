package at.phatbl.swiftpm.tasks

/**
 * Resolves package dependencies.
 */
open class ResolveTask : AbstractExecTask() {
    init {
        description = "Resolves package dependencies."
        command = "swift package resolve"
    }
}
