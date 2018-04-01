package at.phatbl.swiftpm

import at.phatbl.swift.BuildTask
import at.phatbl.swift.TestTask
import at.phatbl.swift.VersionTask
import at.phatbl.swiftpm.Constants.Companion.TASK_CLEAN
import at.phatbl.swiftpm.Constants.Companion.TASK_DESCRIBE
import at.phatbl.swiftpm.Constants.Companion.TASK_DUMP_PACKAGE
import at.phatbl.swiftpm.Constants.Companion.TASK_GENERATE_XCODE_PROJECT
import at.phatbl.swiftpm.Constants.Companion.TASK_RESET
import at.phatbl.swiftpm.Constants.Companion.TASK_SWIFT_BUILD
import at.phatbl.swiftpm.Constants.Companion.TASK_SWIFT_TEST
import at.phatbl.swiftpm.Constants.Companion.TASK_SWIFT_VERSION
import at.phatbl.swiftpm.Constants.Companion.TASK_TOOLS_VERSION
import at.phatbl.swiftpm.Constants.Companion.TASK_VERSION
import at.phatbl.swiftpm.tasks.*
import org.gradle.api.Plugin
import org.gradle.api.Project

class SwiftPMPlugin : Plugin<Project> {
    lateinit var project: Project

    override fun apply(project: Project) {
        this.project = project
        project.logger.info("SwiftPM plugin version: ${Version.text}")

        project.tasks.create(TASK_SWIFT_BUILD, BuildTask::class.java)
        project.tasks.create(TASK_SWIFT_TEST, TestTask::class.java)
        project.tasks.create(TASK_SWIFT_VERSION, VersionTask::class.java)

        project.tasks.create(TASK_CLEAN, CleanTask::class.java)
        project.tasks.create(TASK_DESCRIBE, DescribeTask::class.java)
        project.tasks.create(TASK_DUMP_PACKAGE, DumpPackageTask::class.java)
        project.tasks.create(TASK_GENERATE_XCODE_PROJECT, GenerateXcodeTask::class.java)
        project.tasks.create(TASK_VERSION, PMVersionTask::class.java)
        project.tasks.create(TASK_RESET, ResetTask::class.java)
        project.tasks.create(TASK_TOOLS_VERSION, ToolsVersionTask::class.java)
    }
}
