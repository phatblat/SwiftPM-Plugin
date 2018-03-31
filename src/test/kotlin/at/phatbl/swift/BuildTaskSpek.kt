package at.phatbl.swift

import at.phatbl.swiftpm.Constants
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object BuildTaskSpek: Spek({
    describe("swift version task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(Constants.TASK_SWIFT_BUILD, BuildTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is BuildTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                    "swift",
                    "build"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.commandLine.contains(token))
            }
        }
    }
})
