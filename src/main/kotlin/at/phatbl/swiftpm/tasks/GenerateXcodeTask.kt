package at.phatbl.swiftpm.tasks

/**
 * Generates an Xcode project for the package.
 */
open class GenerateXcodeTask : AbstractExecTask() {
    init {
        description = "Generates an Xcode project for the package."
        command = "swift package generate-xcodeproj"
    }
}
