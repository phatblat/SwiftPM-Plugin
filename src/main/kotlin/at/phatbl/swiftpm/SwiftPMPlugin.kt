package at.phatbl.swiftpm

import at.phatbl.swift.VersionTask
import at.phatbl.swiftpm.Constants.Companion.TASK_CLEAN
import at.phatbl.swiftpm.Constants.Companion.TASK_DESCRIBE
import at.phatbl.swiftpm.Constants.Companion.TASK_DUMP_PACKAGE
import at.phatbl.swiftpm.Constants.Companion.TASK_GENERATE_XCODE_PROJECT
import at.phatbl.swiftpm.Constants.Companion.TASK_RESET
import at.phatbl.swiftpm.Constants.Companion.TASK_SWIFT_VERSION
import at.phatbl.swiftpm.Constants.Companion.TASK_TOOLS_VERSION
import at.phatbl.swiftpm.Constants.Companion.TASK_VERSION
import at.phatbl.swiftpm.tasks.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

class SwiftPMPlugin : Plugin<Project> {
    lateinit var project: Project

    lateinit var swiftVersion: Task

    lateinit var clean: Task
    lateinit var describe: Task
    lateinit var dumpPackage: Task
    lateinit var generateXcodeTask: Task
    lateinit var pmVersion: Task
    lateinit var reset: Task
    lateinit var toolsVersion: Task

    override fun apply(project: Project) {
        this.project = project

        swiftVersion = project.tasks.create(TASK_SWIFT_VERSION, VersionTask::class.java)

        clean = project.tasks.create(TASK_CLEAN, CleanTask::class.java)
        describe = project.tasks.create(TASK_DESCRIBE, DescribeTask::class.java)
        dumpPackage = project.tasks.create(TASK_DUMP_PACKAGE, DumpPackageTask::class.java)
        generateXcodeTask = project.tasks.create(TASK_GENERATE_XCODE_PROJECT, GenerateXcodeTask::class.java)
        pmVersion = project.tasks.create(TASK_VERSION, PMVersionTask::class.java)
        reset = project.tasks.create(TASK_RESET, ResetTask::class.java)
        toolsVersion = project.tasks.create(TASK_TOOLS_VERSION, ToolsVersionTask::class.java)
    }

    /**
     * Logs the plugin version.
     */
    private fun showPluginVersion() {
        val version = getVersion()
        if (version != "") {
            project.logger.info("Plugin version: $version")
        }
    }

    /**
     * Extracts the version of this plugin at runtime based on the Maven file structure. Directory containing
     * the JAR file is inferred as the version number.
     *
     * @return String representation of the version number
     */
    private fun getVersion(): String {
        // This logic only works for projects that depend on the plugin directly, which is typically only the
        // root project.
        if (project.name != project.rootProject.name || project.name == "test") {
            return ""
        }

        val tree = project.buildscript.configurations.getByName("classpath").asFileTree.matching {
            mapOf("include" to "**swiftpm**")
        }

        var jarFileAbsolutePath: String? = null
        tree.forEach {
            file -> jarFileAbsolutePath = "$file"
        }

        // Including the plugin as a library through a composite build breaks this method of version detection.
        if (jarFileAbsolutePath == null) {
            return ""
        }

        val tokens = jarFileAbsolutePath!!.split("/")
        var version = tokens[tokens.count() - 1]

        if (version.length >= 40) {
            // Dependency fetched from gradle cache, version is one folder level higher
            version = tokens[tokens.count() - 2]
        }

        return version
    }
}
