/**
 * build.gradle.kts
 * SwiftPM-Plugin
 */

import org.gradle.api.tasks.wrapper.Wrapper.DistributionType
import org.gradle.kotlin.dsl.`kotlin-dsl`
import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.gradle.plugins.ide.idea.model.IdeaModel
import org.gradle.plugins.ide.idea.model.IdeaModule
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

/* -------------------------------------------------------------------------- */
// Properties
/* -------------------------------------------------------------------------- */

group = "at.phatbl"
version = "0.1.0"

/* -------------------------------------------------------------------------- */
// Build Script
/* -------------------------------------------------------------------------- */

val spekVersion = "1.1.5"
val junitPlatformVersion: String by extra
val junitJupiterVersion  = "5.0.0"
val junitVintageVersion  = "4.12.0"
val junit4Version        = "4.12"

buildscript {
    val junitPlatformVersion by extra("1.0.0")
    repositories {
        maven("https://repo.gradle.org/gradle/repo") // gradleKotlinDsl()
    }
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:$junitPlatformVersion")
    }
}

plugins {
    // Gradle built-in
    idea
    `java-gradle-plugin`

    // Gradle plugin portal - https://plugins.gradle.org/
    kotlin("jvm") version "1.2.31"
}

apply {
    plugin("org.junit.platform.gradle.plugin") // org.junit.platform:junit-platform-gradle-plugin
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

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

/* -------------------------------------------------------------------------- */
// Build Configuration
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

// java
configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

/* -------------------------------------------------------------------------- */
// Testing
/* -------------------------------------------------------------------------- */

junitPlatform {
    platformVersion = junitPlatformVersion
    filters {
        includeClassNamePatterns("^.*Tests?$", ".*Spec", ".*Spek")
        engines {
            include("spek", "junit-jupiter", "junit-vintage")
        }
    }
}

/* -------------------------------------------------------------------------- */
// Deployment
/* -------------------------------------------------------------------------- */

val artifactName = name.toLowerCase()
val javaPackage = "$group.$artifactName"
val pluginClass =  "${name}Plugin"

configure<BasePluginConvention> {
    // at.phatbl.swiftpm-1.0.0.jar
    archivesBaseName = javaPackage
}

gradlePlugin {
    plugins {
        create("swiftpm") {
            id = artifactName
            implementationClass = "$javaPackage.$pluginClass"
        }
    }
}

/* -------------------------------------------------------------------------- */
// Experimental
/* -------------------------------------------------------------------------- */

// IntelliJ IDEA project generation
idea {
    project {
        languageLevel = IdeaLanguageLevel(JavaVersion.VERSION_1_8)
    }
    module {
        isDownloadJavadoc = true // defaults to false
        isDownloadSources = true
    }
}

/* -------------------------------------------------------------------------- */
// Groovy-like DSL
/* -------------------------------------------------------------------------- */

/**
 * Retrieves the [junitPlatform][org.junit.platform.gradle.plugin.JUnitPlatformExtension] project extension.
 */
val Project.`junitPlatform`: JUnitPlatformExtension get() =
    extensions.getByType(JUnitPlatformExtension::class.java)

/**
 * Configures the [junitPlatform][org.junit.platform.gradle.plugin.JUnitPlatformExtension] project extension.
 */
fun Project.`junitPlatform`(configure: JUnitPlatformExtension.() -> Unit) =
    extensions.configure(JUnitPlatformExtension::class.java, configure)

/**
 * Retrieves the [gradlePlugin][org.gradle.plugin.devel.GradlePluginDevelopmentExtension] project extension.
 */
val Project.`gradlePlugin`: GradlePluginDevelopmentExtension get() =
    extensions.getByType(GradlePluginDevelopmentExtension::class.java)

/**
 * Configures the [gradlePlugin][org.gradle.plugin.devel.GradlePluginDevelopmentExtension] project extension.
 */
fun Project.`gradlePlugin`(configure: GradlePluginDevelopmentExtension.() -> Unit) =
        extensions.configure(GradlePluginDevelopmentExtension::class.java, configure)

/**
 * Retrieves the [idea][org.gradle.plugins.ide.idea.model.IdeaModel] project extension.
 */
val Project.`idea`: IdeaModel get() =
    extensions.getByType(IdeaModel::class.java)

/**
 * Configures the [idea][org.gradle.plugins.ide.idea.model.IdeaModel] project extension.
 */
fun Project.`idea`(configure: IdeaModel.() -> Unit) =
        extensions.configure(IdeaModel::class.java, configure)
