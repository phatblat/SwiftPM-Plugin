package at.phatbl.swiftpm.tasks

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object DescribeTaskSpek: Spek({
    describe("clean task") {
        val clazz: Class<DescribeTask> = DescribeTask::class.java
        var project: Project?
        var task: DescribeTask? = null

        beforeEachTest {
            project = ProjectBuilder.builder().build()
            task = project!!.tasks.create("swiftpmClean", clazz)
        }

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
                assertTrue(task!!.commandLine.contains(token))
            }
        }
    }
})
