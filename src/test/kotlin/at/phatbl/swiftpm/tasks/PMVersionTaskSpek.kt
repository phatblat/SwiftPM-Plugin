package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.TASK_VERSION
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object PMVersionTaskSpek: Spek({
    describe("version task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(TASK_VERSION, PMVersionTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is PMVersionTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                "swift",
                "package",
                "--version"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.commandLine.contains(token))
            }
        }
    }
})
