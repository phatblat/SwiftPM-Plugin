/**
 * build.gradle.kts
 * SwiftPM-Plugin
 */

import org.gradle.api.tasks.wrapper.Wrapper.DistributionType
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

val kotlinVersion: String by extra
println("kotlinVersion: $kotlinVersion")
val spekVersion = "1.1.5"
val junitPlatformVersion: String by extra
val junitJupiterVersion  = "5.0.0"
val junitVintageVersion  = "4.12.0"
val junit4Version        = "4.12"

buildscript {
    val kotlinVersion by extra("1.1.51")
    val junitPlatformVersion by extra("1.0.0")
    repositories {
        maven("https://repo.gradle.org/gradle/repo") // gradleKotlinDsl()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
        classpath("org.junit.platform:junit-platform-gradle-plugin:$junitPlatformVersion")
    }
}

plugins {
   `kotlin-dsl` // 0.11.1
//    base
//    `java-gradle-plugin`
}

apply {
    plugin("base")
    plugin("kotlin")
    plugin("java-gradle-plugin")
    plugin("org.junit.platform.gradle.plugin") // junit-platform-gradle-plugin
    plugin("maven")
    plugin("idea")
}

val removeBatchFile by tasks.creating(Delete::class) { delete("gradlew.bat") }

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "4.2"
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

repositories {
    jcenter()
    maven("https://repo.gradle.org/gradle/repo")
    maven("http://dl.bintray.com/jetbrains/spek")
}

// In this section you declare the dependencies for your production and test code
dependencies {
    compile(gradleKotlinDsl())
    compile(kotlin("stdlib", kotlinVersion))
//    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
//    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlinVersion")

    // Speck
    compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testCompile("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    testCompile("org.jetbrains.spek:spek-api:$spekVersion")
    testCompile("org.jetbrains.spek:spek-junit-platform-engine:$spekVersion")
//    testCompile("org.junit.platform:junit-platform-engine:$junitPlatformVersion")
//    testCompile("org.junit.platform:junit-platform-launcher:$junitPlatformVersion")
    testCompile("org.junit.platform:junit-platform-runner:$junitPlatformVersion")

    // JUnit 5
//    testCompile("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
//    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")

    // JUnit 4
//    testCompile("junit:junit:$junit4Version")
//    testRuntime("org.junit.vintage:junit-vintage-engine:$junitVintageVersion")
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
