package at.phatbl.swiftpm

import at.phatbl.swiftpm.tasks.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.FileTree

import static at.phatbl.swiftpm.Constants.*

class SwiftPMPlugin implements Plugin<Project> {
    Project project
    Task version
    Task swiftVersion

    void apply(Project project) {
        this.project = project

        showPluginVersion()

        version = project.task TASK_VERSION, type: VersionTask
        swiftVersion = project.task TASK_SWIFT_VERSION, type: SwiftVersionTask
    }

    /**
     * Logs the pipeline plugin version.
     */
    private void showPluginVersion() {
        String version = getVersion()
        if (version && version != "") {
            project.logger.info "Pipeline plugin version: ${version}"
        }
    }

    /**
     * Extracts the version of this pipeline plugin at runtime based on the Maven file structure. Directory containing
     * the JAR file is inferred as the version number.
     *
     * @return String representation of the version number
     */
    private String getVersion() {
        // This logic only works for projects that depend on the plugin directly, which is typically only the
        // root project.
        if (project.name != project.rootProject.name || project.name == 'test') {
            return ""
        }

        FileTree tree = project.buildscript.configurations.classpath.asFileTree.matching { include "**swiftpm**"}
        String jarFileAbsolutePath
        tree.each { File file -> jarFileAbsolutePath = "${file}" }

        // Including the plugin as a library through a composite build breaks this method of version detection.
        if (jarFileAbsolutePath == null) {
            return ""
        }

        String[] tokens = jarFileAbsolutePath.tokenize('/')
        String version = tokens[-2]

        if (version.length() >= 40) {
            // Dependency fetched from gradle cache, version is one folder level higher
            version = tokens[-3]
        }

        return version
    }
}
