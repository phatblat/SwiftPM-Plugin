package at.phatbl.swift

import at.phatbl.swiftpm.Constants
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object TestTaskSpek: Spek({
    describe("swift test task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(Constants.TASK_SWIFT_TEST, TestTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is TestTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                    "swift",
                    "test"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.commandLine.contains(token))
            }
        }
    }
})
