package at.phatbl.swiftpm.tasks

/**
 * Print the resolved dependency graph.
 */
open class ShowDependenciesTask : AbstractExecTask() {
    init {
        description = "Print the resolved dependency graph."
        command = "swift package show-dependencies"
    }
}
