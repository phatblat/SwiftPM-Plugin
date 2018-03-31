package at.phatbl.swift

import at.phatbl.swiftpm.tasks.AbstractExecTask

/**
 * Builds the Swift package.
 */
open class BuildTask : AbstractExecTask() {
    init {
        description = "Builds the Swift package."
        command = "swift build"
    }
}
