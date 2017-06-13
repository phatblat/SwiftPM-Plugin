package at.phatbl.swiftpm.tasks

import static at.phatbl.swiftpm.Constants.*

/**
 * Prints the version of swift.
 */
class SwiftVersionTask extends AbstractExecTask {
    SwiftVersionTask() {
        description 'Prints the version of Swift being used.'
        group SWIFTPM_TASK_GROUP

        String command = 'swift --version'
        commandLine command.tokenize()
    }
}
