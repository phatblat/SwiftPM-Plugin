package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.TASK_SWIFT_VERSION
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object SwiftVersionTaskSpek: Spek({
    describe("swift version task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(TASK_SWIFT_VERSION, SwiftVersionTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is SwiftVersionTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                "swift",
                "--version"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.commandLine.contains(token))
            }
        }
    }
})
