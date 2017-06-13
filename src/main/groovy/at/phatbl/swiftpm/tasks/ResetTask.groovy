package at.phatbl.swiftpm.tasks

import static at.phatbl.swiftpm.Constants.*

/**
 * Resets the complete cache/build directory.
 * FIXME: Fails if the .build directory doesn't exist.
 */
class ResetTask extends AbstractExecTask {
    ResetTask() {
        description 'Resets the complete cache/build directory.'
        group SWIFTPM_TASK_GROUP

        String command = 'swift package reset'
        commandLine command.tokenize()
    }
}
