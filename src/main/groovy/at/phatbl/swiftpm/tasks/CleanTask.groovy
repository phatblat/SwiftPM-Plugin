package at.phatbl.swiftpm.tasks

import static at.phatbl.swiftpm.Constants.*

/**
 * Deletes build artifacts.
 */
class CleanTask extends AbstractExecTask {
    CleanTask() {
        description 'Deletes build artifacts.'
        group SWIFTPM_TASK_GROUP

        String command = 'swift package clean'
        commandLine command.tokenize()
    }
}