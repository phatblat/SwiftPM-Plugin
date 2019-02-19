package at.phatbl.swiftpm.tasks

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.options.Option

/**
 * Initializes a new package.
  @Inject constructor(
    private val type: Type
  )
 */
open class InitTask : AbstractExecTask() {
    enum class Type(val argument: String) {
        Empty("empty"),
        Library("library"),
        Executable("executable"),
        SystemModule("system-module");

        override fun toString(): String {
            return argument
        }
    }

    /**
     * Type of package to initialize.
     */
    var type: Type = Type.Empty
        @Input
        get() = field
        @Option(option = "type", description = "Type of package to initialize.")
        set(value) {
            field = value
        }

    init {
        description = "Initializes a new package."
        command = "swift package init"
    }

    override fun preExec() {
        command += " --type $type"
        println(command)
    }
}
