package at.phatbl.swiftpm.tasks

import static at.phatbl.swiftpm.Constants.*

/**
 * Prints the version of the swift package manager.
 */
class VersionTask extends AbstractExecTask {
    VersionTask() {
        description 'Prints the version of SwiftPM being used.'
        group SWIFTPM_TASK_GROUP

        String command = 'swift package --version'
        commandLine command.tokenize()
    }
}
