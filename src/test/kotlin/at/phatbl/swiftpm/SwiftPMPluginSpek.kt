package at.phatbl.swiftpm

import at.phatbl.swift.BuildTask
import at.phatbl.swift.TestTask
import at.phatbl.swift.VersionTask
import at.phatbl.swiftpm.Constants.Companion.TASK_CLEAN
import at.phatbl.swiftpm.Constants.Companion.TASK_DESCRIBE
import at.phatbl.swiftpm.Constants.Companion.TASK_DUMP_PACKAGE
import at.phatbl.swiftpm.Constants.Companion.TASK_GENERATE_XCODE_PROJECT
import at.phatbl.swiftpm.Constants.Companion.TASK_RESET
import at.phatbl.swiftpm.Constants.Companion.TASK_RESOLVE
import at.phatbl.swiftpm.Constants.Companion.TASK_SHOW_DEPENDENCIES
import at.phatbl.swiftpm.Constants.Companion.TASK_SWIFT_BUILD
import at.phatbl.swiftpm.Constants.Companion.TASK_SWIFT_TEST
import at.phatbl.swiftpm.Constants.Companion.TASK_SWIFT_VERSION
import at.phatbl.swiftpm.Constants.Companion.TASK_TOOLS_VERSION
import at.phatbl.swiftpm.Constants.Companion.TASK_UPDATE
import at.phatbl.swiftpm.Constants.Companion.TASK_VERSION
import at.phatbl.swiftpm.tasks.*
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object SwiftPMPluginSpek: Spek({
    describe("swift pm plugin") {
        val project = ProjectBuilder.builder().build()
        project.plugins.apply(SwiftPMPlugin::class.java)

        context("swift") {
            it("has a swift build task") {
                val task = project.tasks.findByName(TASK_SWIFT_BUILD)
                assertNotNull(task)
                assertTrue { task is BuildTask }
            }
            it("has a swift test task") {
                val task = project.tasks.findByName(TASK_SWIFT_TEST)
                assertNotNull(task)
                assertTrue { task is TestTask }
            }
            it("has a swift version task") {
                val task = project.tasks.findByName(TASK_SWIFT_VERSION)
                assertNotNull(task)
                assertTrue { task is VersionTask }
            }
        }

        context("swiftpm") {
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

            it("has a generate xcode project task") {
                val task = project.tasks.findByName(TASK_GENERATE_XCODE_PROJECT)
                assertNotNull(task)
                assertTrue { task is GenerateXcodeTask }
            }

            it("has a pm version task") {
                val task = project.tasks.findByName(TASK_VERSION)
                assertNotNull(task)
                assertTrue { task is PMVersionTask }
            }

            it("has a reset task") {
                val task = project.tasks.findByName(TASK_RESET)
                assertNotNull(task)
                assertTrue { task is ResetTask }
            }

            it("has a resolve task") {
                val task = project.tasks.findByName(TASK_RESOLVE)
                assertNotNull(task)
                assertTrue { task is ResolveTask }
            }

            it("has a show dependencies task") {
                val task = project.tasks.findByName(TASK_SHOW_DEPENDENCIES)
                assertNotNull(task)
                assertTrue { task is ShowDependenciesTask }
            }

            it("has a tools version task") {
                val task = project.tasks.findByName(TASK_TOOLS_VERSION)
                assertNotNull(task)
                assertTrue { task is ToolsVersionTask }
            }

            it("has an update task") {
                val task = project.tasks.findByName(TASK_UPDATE)
                assertTrue { task is UpdateTask }
            }
        }
    }
})
