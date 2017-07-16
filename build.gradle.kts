/**
 * build.gradle.kts
 * SwiftPM-Plugin
 */

/* -------------------------------------------------------------------------- */
// Properties
/* -------------------------------------------------------------------------- */

group = "at.phatbl"
version = "0.1.0"

/* -------------------------------------------------------------------------- */
// Build Script
/* -------------------------------------------------------------------------- */

val kotlinVersion = "1.1.3"
val spekVersion = "1.1.2"
val junitPlatformVersion = "1.0.0-M4"
val junitJupiterVersion  = "5.0.0-M4"
val junitVintageVersion  = "4.12.0-M4"
val junit4Version        = "4.12"

buildscript {
    val kotlinVersion = "1.1.3"
    val junitPlatformVersion = "1.0.0-M4"
//    ext {
//        kotlinVersion = "1.1.3"
//        spekVersion = "1.1.2"
//        junitPlatformVersion = "1.0.0-M4"
//        junitJupiterVersion  = "5.0.0-M4"
//        junitVintageVersion  = "4.12.0-M4"
//        junit4Version        = "4.12"
//    }
    repositories {
        maven { url = uri("https://repo.gradle.org/gradle/repo") }
//        maven { url = uri("https://plugins.gradle.org/m2/") }
//        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.junit.platform:junit-platform-gradle-plugin:$junitPlatformVersion")
    }
}

plugins {
//    `kotlin-dsl`
//    `java-gradle-plugin`
}

apply {
    plugin("kotlin")
    plugin("org.jetbrains.kotlin.jvm")
    plugin("java-gradle-plugin")
    plugin("org.junit.platform.gradle.plugin") // junit-platform-gradle-plugin
    plugin("maven")
    plugin("idea")
}

val removeBatchFile by tasks.creating(Delete::class) {
    delete("gradlew.bat")
}

//val wrapper by tasks.getting(Wrapper::class)
tasks {
    /**
     *
     * https://services.gradle.org/distributions/gradle-4.0.1-all.zip
     * https://repo.gradle.org/gradle/dist-snapshots/gradle-kotlin-dsl-4.1-20170622074548+0000-all.zip
     * https://repo.gradle.org/gradle/dist-snapshots/gradle-kotlin-dsl-4.1-20170713163104+0000-all.zip
     * https://repo.gradle.org/gradle/dist-snapshots/gradle-script-kotlin-4.1-20170615174816+0000-all.zip
     */
    "wrapper"(Wrapper::class) {
        gradleVersion = "4.0.1"
//import org.gradle.api.tasks.wrapper.Wrapper.DistributionType
//        distributionType = org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL
        distributionUrl = "https://repo.gradle.org/gradle/dist-snapshots/gradle-script-kotlin-4.1-20170615174816+0000-all.zip"

        finalizedBy(removeBatchFile)
    }
}

/* -------------------------------------------------------------------------- */
// Build Configuration
/* -------------------------------------------------------------------------- */

repositories {
    jcenter()
    maven { url = uri("https://repo.gradle.org/gradle/repo") }
    maven { url = uri("http://dl.bintray.com/jetbrains/spek") }
}

// In this section you declare the dependencies for your production and test code
dependencies {
    compile(gradleScriptKotlinApi())
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

//compileKotlin {
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}

/* -------------------------------------------------------------------------- */
// Testing
/* -------------------------------------------------------------------------- */

//compileTestKotlin {
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}

// org.junit.platform.gradle.plugin
//junitPlatform {
//    platformVersion junitPlatformVersion
//    filters {
//        engines {
//            include "spek", "junit-jupiter", "junit-vintage"
//        }
//        includeClassNamePatterns "^.*Tests?$", ".*Spec", ".*Spek"
//    }
//}

//test {
//    testLogging {
//        //events "started", "passed", "failed"
//    }
//}

/* -------------------------------------------------------------------------- */
// Deployment
/* -------------------------------------------------------------------------- */

//ext {
//    artifactName = name.toLowerCase()
//    javaPackage = group + "." + artifactName
//    pluginClass =  name + "Plugin"
//}

val artifactName = name.toLowerCase()
val javaPackage = "$group.$artifactName"
val pluginClass =  "${name}Plugin"

// at.phatbl.swiftpm-1.0.0.jar
//archivesBaseName = javaPackage

// java-gradle-plugin
configure<GradlePluginDevelopmentExtension> {
    plugins {
        create("swiftpm") {
            id = artifactName
            implementationClass = "$javaPackage.$pluginClass"
        }
    }
}

// maven
//uploadArchives {
//    repositories.mavenDeployer {
//        repository url: "file://$buildDir/maven/repo"
//        pom.artifactId = artifactName
//    }
//}

/* -------------------------------------------------------------------------- */
// Experimental
/* -------------------------------------------------------------------------- */

// IntelliJ IDEA project generation
//idea {
//    project {
//        languageLevel = JavaVersion.VERSION_1_8
//    }
//    module {
//        downloadJavadoc = true // defaults to false
//        downloadSources = true
//    }
//}
