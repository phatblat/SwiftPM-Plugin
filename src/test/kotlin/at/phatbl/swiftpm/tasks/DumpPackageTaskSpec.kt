package at.phatbl.swiftpm.tasks

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object DumpPackageTaskSpec: Spek({
    describe("dump package task") {
        var project = ProjectBuilder.builder().build()
        var task = project.tasks.create("swiftpmDumpPackage", DumpPackageTask::class.java)

        beforeEachTest {
            project = ProjectBuilder.builder().build()
            task = project.tasks.create("swiftpmDumpPackage", DumpPackageTask::class.java)
        }

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is DumpPackageTask }
        }
    }
})
