package at.phatbl.swiftpm

/**
 * Created by phatblat on 7/10/17.
 */
class Constants {
    companion object {
        const val SWIFTPM_TASK_GROUP = "📦 SwiftPM"

        // SwiftPM task names
        const val SPM_TASK_PREFIX = "swiftpm"
        const val TASK_CLEAN = SPM_TASK_PREFIX + "Clean"
        const val TASK_DESCRIBE = SPM_TASK_PREFIX + "Describe"
        const val TASK_DUMP_PACKAGE = SPM_TASK_PREFIX + "DumpPackage"
        const val TASK_GENERATE_XCODE_PROJECT = SPM_TASK_PREFIX + "GenerateXcodeProject"
        const val TASK_RESET = SPM_TASK_PREFIX + "Reset"
        const val TASK_TOOLS_VERSION = SPM_TASK_PREFIX + "ToolsVersion"
        const val TASK_VERSION = SPM_TASK_PREFIX + "Version"

        // Swift task names
        const val SWIFT_TASK_PREFIX = "swift"
        const val TASK_SWIFT_VERSION = SWIFT_TASK_PREFIX + "Version"
    }
}