package at.phatbl.swiftpm

/**
 * Created by phatblat on 6/13/17.
 */
class Constants {
    static String SWIFTPM_TASK_GROUP = "SwiftPM"

    // SwiftPM task names
    static String SPM_TASK_PREFIX = 'swiftpm'
    static String TASK_VERSION = SPM_TASK_PREFIX + 'Version'
    static String TASK_TOOLS_VERSION = SPM_TASK_PREFIX + 'ToolsVersion'
    static String TASK_CLEAN = SPM_TASK_PREFIX + 'Clean'
    static String TASK_RESET = SPM_TASK_PREFIX + 'Reset'

    // Swift task names
    static String SWIFT_TASK_PREFIX = 'swift'
    static String TASK_SWIFT_VERSION = SWIFT_TASK_PREFIX + 'Version'
}
