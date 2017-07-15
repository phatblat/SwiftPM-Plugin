package at.phatbl.swiftpm

import at.phatbl.swiftpm.Constants.Companion.TASK_CLEAN
import at.phatbl.swiftpm.Constants.Companion.TASK_DESCRIBE
import at.phatbl.swiftpm.Constants.Companion.TASK_DUMP_PACKAGE
import at.phatbl.swiftpm.Constants.Companion.TASK_RESET
import at.phatbl.swiftpm.Constants.Companion.TASK_SWIFT_VERSION
import at.phatbl.swiftpm.Constants.Companion.TASK_TOOLS_VERSION
import at.phatbl.swiftpm.Constants.Companion.TASK_VERSION
import at.phatbl.swiftpm.tasks.*
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object SwiftPMPluginSpek: Spek({
    describe("plugin") {
        val project = ProjectBuilder.builder().build()
        project.plugins.apply(SwiftPMPlugin::class.java)

        it("has a clean task") {
            val task = project.tasks.findByName(TASK_CLEAN)
            assertNotNull(task)
            assertTrue { task is CleanTask }
        }

        it("has a describe task") {
            val task = project.tasks.findByName(TASK_DESCRIBE)
            assertNotNull(task)
            assertTrue { task is DescribeTask }
        }

        it("has a dump package task") {
            val task = project.tasks.findByName(TASK_DUMP_PACKAGE)
            assertNotNull(task)
            assertTrue { task is DumpPackageTask }
        }

        it("has a reset task") {
            val task = project.tasks.findByName(TASK_RESET)
            assertNotNull(task)
            assertTrue { task is ResetTask }
        }

        it("has a swift version task") {
            val task = project.tasks.findByName(TASK_SWIFT_VERSION)
            assertNotNull(task)
            assertTrue { task is SwiftVersionTask }
        }

        it("has a tools version task") {
            val task = project.tasks.findByName(TASK_TOOLS_VERSION)
            assertNotNull(task)
            assertTrue { task is ToolsVersionTask }
        }

        it("has a version task") {
            val task = project.tasks.findByName(TASK_VERSION)
            assertNotNull(task)
            assertTrue { task is VersionTask }
        }
    }
})