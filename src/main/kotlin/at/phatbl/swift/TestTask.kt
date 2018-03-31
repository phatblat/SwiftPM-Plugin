package at.phatbl.swift

import at.phatbl.swiftpm.tasks.AbstractExecTask

/**
 * Tests the Swift package.
 */
open class TestTask : AbstractExecTask() {
    init {
        description = "Tests the Swift package."
        command = "swift test"
    }
}
