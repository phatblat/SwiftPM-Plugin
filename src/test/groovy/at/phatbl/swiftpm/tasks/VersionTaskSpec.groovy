package at.phatbl.swiftpm.tasks

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

/**
 * Created by phatblat on 6/13/17.
 */
class VersionTaskSpec extends Specification {
    Project project
    Task task

    def setup() {
        project = ProjectBuilder.builder().build()
        task = project.task 'swiftpmVersion', type: VersionTask
    }

    def cleanup() {
        project = null
    }

    def "can be added to project"() {
        expect:
        task != null
        task instanceof VersionTask
    }

    def "command contains tokens"() {
        expect:
        task.commandLine.containsAll([
            'swift',
            'package',
            '--version'
        ])
    }
}
