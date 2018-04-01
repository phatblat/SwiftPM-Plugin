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

        for ((taskName, clazz) in mapOf(
                TASK_SWIFT_BUILD to BuildTask::class.java,
                TASK_SWIFT_TEST to TestTask::class.java,
                TASK_SWIFT_VERSION to VersionTask::class.java,
                TASK_CLEAN to CleanTask::class.java,
                TASK_DESCRIBE to DescribeTask::class.java,
                TASK_DUMP_PACKAGE to DumpPackageTask::class.java,
                TASK_GENERATE_XCODE_PROJECT to GenerateXcodeTask::class.java,
                TASK_VERSION to PMVersionTask::class.java,
                TASK_RESET to ResetTask::class.java,
                TASK_TOOLS_VERSION to ToolsVersionTask::class.java
        )) project.tasks.create(taskName, clazz)
    }
}
