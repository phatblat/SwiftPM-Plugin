package at.phatbl.swiftpm.tasks

/**
 * OVERVIEW: Manipulate tools version of the current package

OPTIONS:
--set           Set tools version of package to the given value
--set-current   Set tools version of package to the current tools version in use
 */
open class ToolsVersionTask : AbstractExecTask() {
    init {
        description = "Shows tools version of the current package."
        command = "swift package tools-version"
    }
}
