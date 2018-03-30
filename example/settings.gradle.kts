/*
 * settings.gradle.kts
 * SwiftPM-Plugin example
 */

rootProject.name = "example"

val swiftPM = file("../")
// Include SwiftPM plugin project in composite build
includeBuild(swiftPM) {
    dependencySubstitution {
        substitute(module("at.phatbl:swiftpm")).with(project(":"))
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "at.phatbl.swiftpm" ->
                    useModule("at.phatbl:swiftpm:${requested.version}")
                "org.junit.platform.gradle.plugin" ->
                    useModule("org.junit.platform:junit-platform-gradle-plugin:${requested.version}")
                else -> Unit
            }
        }
    }
}
