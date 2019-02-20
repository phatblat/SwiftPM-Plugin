package at.phatbl.swiftpm.tasks

import at.phatbl.swiftpm.Constants.Companion.TASK_INIT
import at.phatbl.swiftpm.tasks.InitTask.Type
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xit
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object InitTaskSpek: Spek({
    describe("init task") {
        val project = ProjectBuilder.builder().build()
        val task = project.tasks.create(TASK_INIT, InitTask::class.java)

        it("can be added to project") {
            assertNotNull(task)
            assertTrue { task is InitTask }
        }

        it("has a tokenized command line") {
            val expectedTokens = arrayOf(
                "swift",
                "package",
                "init"
            )

            expectedTokens.forEach { token ->
                assertTrue(task.command.contains(token))
            }
        }

        it("contains type in command") {
            val expectedTokens = arrayOf(
                "swift",
                "package",
                "init",
                "--type",
                "empty"
            )

            task.preExec()

            expectedTokens.forEach { token ->
                assertTrue(task.command.contains(token))
            }
        }

        it("can init a library package") {
            task.type = Type.Library
            task.preExec()

            assertTrue(task.command.contains("--type library"))
        }

        it("can init an executable package") {
            task.type = Type.Executable
            task.preExec()

            assertTrue(task.command.contains("--type executable"))
        }

        it("can init a system module package") {
            task.type = Type.SystemModule
            task.preExec()

            assertTrue(task.command.contains("--type system-module"))
        }
    }
})
