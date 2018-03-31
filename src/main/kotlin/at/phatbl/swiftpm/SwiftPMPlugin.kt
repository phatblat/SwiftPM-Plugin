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
import org.gradle.api.Task

class SwiftPMPlugin : Plugin<Project> {
    lateinit var project: Project

    lateinit var build: Task
    lateinit var test: Task
    lateinit var version: Task

    lateinit var clean: Task
    lateinit var describe: Task
    lateinit var dumpPackage: Task
    lateinit var generateXcodeTask: Task
    lateinit var pmVersion: Task
    lateinit var reset: Task
    lateinit var toolsVersion: Task

    override fun apply(project: Project) {
        this.project = project
        project.logger.info("SwiftPM plugin version: ${Version.text}")

        build = project.tasks.create(TASK_SWIFT_BUILD, BuildTask::class.java)
        test = project.tasks.create(TASK_SWIFT_TEST, TestTask::class.java)
        version = project.tasks.create(TASK_SWIFT_VERSION, VersionTask::class.java)

        clean = project.tasks.create(TASK_CLEAN, CleanTask::class.java)
        describe = project.tasks.create(TASK_DESCRIBE, DescribeTask::class.java)
        dumpPackage = project.tasks.create(TASK_DUMP_PACKAGE, DumpPackageTask::class.java)
        generateXcodeTask = project.tasks.create(TASK_GENERATE_XCODE_PROJECT, GenerateXcodeTask::class.java)
        pmVersion = project.tasks.create(TASK_VERSION, PMVersionTask::class.java)
        reset = project.tasks.create(TASK_RESET, ResetTask::class.java)
        toolsVersion = project.tasks.create(TASK_TOOLS_VERSION, ToolsVersionTask::class.java)
    }
}
