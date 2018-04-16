package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.TASK_DESCRIBE
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object DescribeTaskSpek: Spek({
    describe("describe task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(TASK_DESCRIBE, DescribeTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is DescribeTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                "swift",
                "package",
                "describe"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.command.contains(token))
            }
        }
    }
})
