package at.phatbl.swiftpm.tasks

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object CleanTaskSpek: Spek({
    describe("clean task") {
        val clazz: Class<CleanTask> = CleanTask::class.java
        var project: Project?
        var task: CleanTask? = null

        beforeEachTest {
            project = ProjectBuilder.builder().build()
            task = project!!.tasks.create("swiftpmClean", clazz)
        }

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is CleanTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                "swift",
                "package",
                "clean"
            )

            expectedTokens.forEach { token ->
                assertTrue(task!!.commandLine.contains(token))
            }
        }
    }
})
