package at.phatbl.swiftpm.tasks

import static at.phatbl.swiftpm.Constants.*

/**
 * Prints a summary of the modules defined by in the package.
 */
class DescribeTask extends AbstractExecTask {
    DescribeTask() {
        description 'Prints the version of SwiftPM being used.'
        group SWIFTPM_TASK_GROUP

        String command = 'swift package describe'
        commandLine command.tokenize()
    }
}
