package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.TASK_RESET
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object ResetTaskSpek: Spek({
    describe("reset task") {
        val clazz: Class<ResetTask> = ResetTask::class.java
        var project: Project?
        var task: ResetTask? = null

        beforeEachTest {
            project = ProjectBuilder.builder().build()
            task = project!!.tasks.create(TASK_RESET, clazz)
        }

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is ResetTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                "swift",
                "package",
                "reset"
            )

            expectedTokens.forEach { token ->
                assertTrue(task!!.commandLine.contains(token))
            }
        }
    }
})
