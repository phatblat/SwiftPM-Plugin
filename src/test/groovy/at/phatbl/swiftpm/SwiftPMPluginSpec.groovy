package at.phatbl.swiftpm

import at.phatbl.swiftpm.tasks.*
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Shared
import spock.lang.Specification

import static at.phatbl.swiftpm.Constants.*

class SwiftPMPluginSpec extends Specification {
    @Shared Project project
    @Shared Task task

    def setup() {
        project = ProjectBuilder.builder().build()
        project.apply plugin: SwiftPMPlugin
    }

    def "has a version task"() {
        when:
        task = project.tasks.swiftpmVersion

        then:
        task != null
        task instanceof VersionTask
    }

    def "has a clean task"() {
        when:
        task = project.tasks.swiftpmClean

        then:
        task != null
        task instanceof CleanTask
    }

    def "has a reset task"() {
        when:
        task = project.tasks.swiftpmReset

        then:
        task != null
        task instanceof ResetTask
    }

    def "has a swift version task"() {
        when:
        task = project.tasks.swiftVersion

        then:
        task != null
        task instanceof SwiftVersionTask
    }
}
