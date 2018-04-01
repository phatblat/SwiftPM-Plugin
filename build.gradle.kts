/**
 * build.gradle.kts
 * SwiftPM-Plugin
 */

/* -------------------------------------------------------------------------- */
// 🛃 Imports
/* -------------------------------------------------------------------------- */

import org.gradle.api.tasks.wrapper.Wrapper.DistributionType
import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.include
import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.gradle.plugins.ide.idea.model.IdeaModel
import org.gradle.plugins.ide.idea.model.IdeaModule
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.preprocessor.mkdirsOrFail
import org.junit.platform.console.options.Details
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension
import java.util.Date

/* -------------------------------------------------------------------------- */
// 🔌 Plugins
/* -------------------------------------------------------------------------- */

plugins {
    // Gradle built-in
    `java-gradle-plugin`
    maven // only applied to make bintray happy
    `maven-publish`

    // Gradle plugin portal - https://plugins.gradle.org/
    kotlin("jvm") version "1.2.31"
    id("at.phatbl.clamp") version "1.0.0"
    id("com.jfrog.bintray") version "1.8.0"
    id("com.gradle.plugin-publish") version "0.9.10"

    // Custom handling in pluginManagement
    id("org.junit.platform.gradle.plugin") version "1.1.0"
}

/* -------------------------------------------------------------------------- */
// 📋 Properties
/* -------------------------------------------------------------------------- */

val artifactName by project
val javaPackage = "$group.$artifactName"
val pluginClass by project
val projectUrl by project
val tags by project
val labels = "$tags".split(",")
val license by project

val jvmTarget = JavaVersion.VERSION_1_8.toString()
val spekVersion by project

// This is necessary to make the plugin version accessible in other places
// https://stackoverflow.com/questions/46053522/how-to-get-ext-variables-into-plugins-block-in-build-gradle-kts/47507441#47507441
val junitPlatformVersion: String? by extra {
    buildscript.configurations["classpath"]
            .resolvedConfiguration.firstLevelModuleDependencies
            .find { it.moduleName == "junit-platform-gradle-plugin" }?.moduleVersion
}

val removeBatchFile by tasks.creating(Delete::class) { delete("gradlew.bat") }

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "4.6"
        distributionType = DistributionType.ALL
        finalizedBy(removeBatchFile)
    }

    "test"(Test::class) {
        testLogging {
            events("started", "passed", "failed")
        }
    }
}

/* -------------------------------------------------------------------------- */
// 👪 Dependencies
/* -------------------------------------------------------------------------- */

repositories.jcenter()

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
    testImplementation("org.junit.platform:junit-platform-runner:$junitPlatformVersion")
    testImplementation("org.jetbrains.spek:spek-api:$spekVersion")
    testImplementation("org.jetbrains.spek:spek-junit-platform-engine:$spekVersion")
}

/* -------------------------------------------------------------------------- */
// 🏗 Assemble
/* -------------------------------------------------------------------------- */

tasks.withType<JavaCompile> {
    sourceCompatibility = jvmTarget
    targetCompatibility = jvmTarget
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = jvmTarget
}
// Include resources
java.sourceSets["main"].resources {
    setSrcDirs(mutableListOf("src/main/resources"))
    include("VERSION.txt")
}

val updateVersionFile by tasks.creating {
    description = "Updates the VERSION.txt file included with the plugin"
    group = "Build"
    doLast {
        val resources = "src/main/resources"
        project.file(resources).mkdirsOrFail()
        val versionFile = project.file("$resources/VERSION.txt")
        versionFile.createNewFile()
        versionFile.writeText(version.toString())
    }
}

tasks.getByName("assemble").dependsOn(updateVersionFile)

val sourcesJar by tasks.creating(Jar::class) {
    dependsOn("classes")
    classifier = "sources"
    from(java.sourceSets["main"].allSource)
}

val javadocJar by tasks.creating(Jar::class) {
    dependsOn("javadoc")
    classifier = "javadoc"
    val javadoc = tasks.withType<Javadoc>().first()
    from(javadoc.destinationDir)
}

artifacts.add("archives", sourcesJar)
artifacts.add("archives", javadocJar)

configure<BasePluginConvention> {
    // at.phatbl.clamp-1.0.0.jar
    archivesBaseName = javaPackage
}

gradlePlugin.plugins.create("$artifactName") {
    id = javaPackage
    implementationClass = "$javaPackage.$pluginClass"
}

pluginBundle {
    website = "$projectUrl"
    vcsUrl = "$projectUrl"
    description = project.description
    tags = labels

    plugins.create("$artifactName") {
        id = javaPackage
        displayName = "${project.name} plugin"
    }
    mavenCoordinates.artifactId = "$artifactName"
}

/* -------------------------------------------------------------------------- */
// ✅ Test
/* -------------------------------------------------------------------------- */

junitPlatform {
    filters {
        engines {
            include("spek")
        }
    }
    details = Details.TREE
}

/* -------------------------------------------------------------------------- */
// 🔍 Code Quality
/* -------------------------------------------------------------------------- */

val codeQuality by tasks.creating

/* -------------------------------------------------------------------------- */
// 🚀 Deployment
/* -------------------------------------------------------------------------- */

publishing {
    (publications) {
        "mavenJava"(MavenPublication::class) {
            from(components["java"])
            artifactId = "$artifactName"

            artifact(sourcesJar) { classifier = "sources" }
            artifact(javadocJar) { classifier = "javadoc" }
        }
    }
}

bintray {
    user = property("bintray.user") as String
    key = property("bintray.api.key") as String
    setPublications("mavenJava")
    setConfigurations("archives")
    dryRun = false
    publish = true
    pkg.apply {
        repo = property("bintray.repo") as String
        name = project.name
        desc = project.description
        websiteUrl = "$projectUrl"
        issueTrackerUrl = "$projectUrl/issues"
        vcsUrl = "$projectUrl.git"
        githubRepo = "phatblat/${project.name}-Plugin"
        githubReleaseNotesFile = "CHANGELOG.md"
        setLicenses("$license")
        setLabels("gradle", "plugin", "wrapper")
        publicDownloadNumbers = true
        version.apply {
            name = project.version.toString()
            desc = "${project.name} Gradle Plugin ${project.version}"
            released = Date().toString()
            vcsTag = project.version.toString()
            attributes = mapOf("gradle-plugin" to "${project.group}:$artifactName:$version")

            mavenCentralSync.apply {
                sync = false //Optional (true by default). Determines whether to sync the version to Maven Central.
                user = "userToken" //OSS user token
                password = "password" //OSS user password
                close = "1" //Optional property. By default the staging repository is closed and artifacts are released to Maven Central. You can optionally turn this behaviour off (by puting 0 as value) and release the version manually.
            }
        }
    }
}

// Workaround to eliminate warning from bintray plugin, which assumes the "maven" plugin is being used.
// https://github.com/bintray/gradle-bintray-plugin/blob/master/src/main/groovy/com/jfrog/bintray/gradle/BintrayPlugin.groovy#L85
val install by tasks
install.doFirst {
    val maven = project.convention.plugins["maven"] as MavenPluginConvention
    maven.mavenPomDir = file("$buildDir/publications/mavenJava")
    logger.info("Configured maven plugin to use same output dir as maven-publish: ${maven.mavenPomDir}")
}

val deploy by tasks.creating {
    description = "Deploys the artifact."
    group = "Deployment"
    dependsOn("bintrayUpload")
    dependsOn("publishPlugins")
}
