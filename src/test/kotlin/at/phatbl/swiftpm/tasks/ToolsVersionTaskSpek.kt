package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.TASK_TOOLS_VERSION
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object ToolsVersionTaskSpek: Spek({
    describe("tools version task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(TASK_TOOLS_VERSION, ToolsVersionTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is ToolsVersionTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                "swift",
                "package",
                "tools-version"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.command.contains(token))
            }
        }
    }
})
