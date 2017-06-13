package at.phatbl.swiftpm

import at.phatbl.swiftpm.tasks.VersionTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Shared
import spock.lang.Specification

class SwiftPMPluginSpec extends Specification {
    @Shared Project project
    @Shared Task task

    def "project has a version task"() {
        when:
        project = ProjectBuilder.builder().build()
        project.apply plugin: SwiftPMPlugin
        task = project.tasks.swiftpmVersion

        then:
        task != null
        task instanceof VersionTask
    }
}
