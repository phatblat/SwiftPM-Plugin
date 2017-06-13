package at.phatbl.swiftpm.tasks

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Shared
import spock.lang.Specification

import static at.phatbl.swiftpm.Constants.*

/**
 * Created by phatblat on 6/13/17.
 */
class CleanTaskSpec extends Specification {
    @Shared Project project
    @Shared Task task

    def setup() {
        project = ProjectBuilder.builder().build()
        task = project.task TASK_CLEAN, type: CleanTask
    }

    def "can be added to project"() {
        expect:
        task != null
        task instanceof CleanTask
    }

    def "command contains tokens"() {
        expect:
        task.commandLine.containsAll([
            'swift',
            'package',
            'clean'
        ])
    }
}
