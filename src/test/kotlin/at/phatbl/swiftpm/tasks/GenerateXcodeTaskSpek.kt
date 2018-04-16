package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.TASK_CLEAN
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object GenerateXcodeTaskSpek: Spek({
    describe("generate xcode task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(TASK_CLEAN, GenerateXcodeTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is GenerateXcodeTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                    "swift",
                    "package",
                    "generate-xcodeproj"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.command.contains(token))
            }
        }
    }
})
