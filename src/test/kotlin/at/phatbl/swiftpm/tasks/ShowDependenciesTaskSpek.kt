package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object ShowDependenciesTaskSpek: Spek({
    describe("show dependencies task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(Constants.TASK_SHOW_DEPENDENCIES, ShowDependenciesTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is ShowDependenciesTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                    "swift",
                    "package",
                    "show-dependencies"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.command.contains(token))
            }
        }
    }
})
