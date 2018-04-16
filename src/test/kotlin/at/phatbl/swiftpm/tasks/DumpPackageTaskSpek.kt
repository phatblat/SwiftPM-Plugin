package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.TASK_DUMP_PACKAGE
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object DumpPackageTaskSpek: Spek({
    describe("dump package task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(TASK_DUMP_PACKAGE, DumpPackageTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is DumpPackageTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                "swift",
                "package",
                "dump-package"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.command.contains(token))
            }
        }
    }
})
