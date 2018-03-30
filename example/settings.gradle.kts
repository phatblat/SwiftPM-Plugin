/*
 * settings.gradle.kts
 * SwiftPM-Plugin example
 */

rootProject.name = "example"

// Include SwiftPM plugin project in composite build
includeBuild("../") {
    dependencySubstitution {
        substitute(module("at.phatbl:swiftpm")).with(project(":"))
    }
}
