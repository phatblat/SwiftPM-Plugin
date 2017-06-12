package at.phatbl.swiftpm

import org.gradle.api.Plugin
import org.gradle.api.Project

class SwiftPMPlugin implements Plugin<Project> {
    Project project

    void apply(Project project) {
        this.project = project
    }
}
