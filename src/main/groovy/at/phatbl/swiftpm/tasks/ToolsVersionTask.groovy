package at.phatbl.swiftpm.tasks

import static at.phatbl.swiftpm.Constants.*

/**
 * OVERVIEW: Manipulate tools version of the current package

 OPTIONS:
 --set           Set tools version of package to the given value
 --set-current   Set tools version of package to the current tools version in use
 */
class ToolsVersionTask extends AbstractExecTask {
    ToolsVersionTask() {
        description 'Show tools version of the current package.'
        group SWIFTPM_TASK_GROUP

        String command = 'swift package tools-version'
        commandLine command.tokenize()
    }
}
