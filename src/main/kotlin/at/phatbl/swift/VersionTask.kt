package at.phatbl.swift

import at.phatbl.swiftpm.tasks.AbstractExecTask

/**
 * Prints the version of swift.
 */
open class VersionTask : AbstractExecTask() {
    init {
        description = "Prints the version of Swift being used."
        command = "swift --version"
    }
}
