package at.phatbl.swiftpm.tasks

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object DumpPackageTaskSpek: Spek({
    describe("dump package task") {
        val clazz: Class<DumpPackageTask> = DumpPackageTask::class.java
        var project: Project?
        var task: DumpPackageTask? = null

        beforeEachTest {
            project = ProjectBuilder.builder().build()
            task = project!!.tasks.create("swiftpmDumpPackage", clazz)
        }

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
                assertTrue(task!!.commandLine.contains(token))
            }
        }
    }
})
