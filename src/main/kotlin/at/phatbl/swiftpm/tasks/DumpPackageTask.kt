package at.phatbl.swiftpm.tasks

// TODO: Figure out how to extend AbstractExecTask groovy class
//import at.phatbl.swiftpm.tasks.AbstractExecTask
import org.gradle.api.tasks.Exec

// TODO: Figure out how to import static members
//import at.phatbl.swiftpm.Constants.*

class DumpPackageTask : Exec() {
    fun DumpPackageTask() {
        description = "Prints parsed Package.swift as JSON"
        group = "SwiftPM"
    }
}