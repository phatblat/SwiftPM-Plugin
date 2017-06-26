package at.phatbl.swiftpm.tasks

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import kotlin.test.assertEquals

object DumpPackageTaskSpec: Spek({
    describe("dump package task") {
        var project: Project
        var task: Task

        beforeEachTest {
            project = ProjectBuilder.builder().build()
            task = project.tasks.create("swiftpmDumpPackage", DumpPackageTask::class)
        }

        it("should return the result of adding the first number to the second number") {
            assertEquals(6, 6)
        }

    }
})
