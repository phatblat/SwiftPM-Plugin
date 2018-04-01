# SwiftPM Plugin

[![Tube](https://jenkins.log-g.co/buildStatus/icon?job=phatblat/SwiftPM-Plugin/master)](https://jenkins.log-g.co/job/phatblat/job/SwiftPM-Plugin/job/master/)
[![codebeat badge](https://codebeat.co/badges/7fcaa41d-d366-4904-8b7c-05ec91aebb85)](https://codebeat.co/projects/github-com-phatblat-swiftpm-plugin-master)
[![Kotlin 1.2.31](https://img.shields.io/badge/Kotlin-1.2.31-orange.svg?style=flat)](http://kotlinlang.org/)

🐘🔌📦 Gradle plugin for the [Swift Package Manager](https://github.com/apple/swift-package-manager).

Note that only tools [version 4](https://github.com/apple/swift-package-manager/blob/master/Documentation/PackageDescriptionV4.md#packagedescription-api-version-4)
is supported.

## Tasks

- `swiftBuild` - Builds the Swift package.
- `swiftTest` - Tests the Swift package.
- `swiftVersion` - Prints the version of Swift being used.
- `swiftpmClean` - Deletes build artifacts.
- `swiftpmDescribe` - Prints a summary of the modules defined by in the package.
- `swiftpmDumpPackage` - Prints parsed Package.swift as JSON.
- `swiftpmGenerateXcodeProject` - Generates an Xcode project for the package.
- `swiftpmReset` - Resets the complete cache/build directory.
- `swiftpmToolsVersion` - Show tools version of the current package.
- `swiftpmVersion` - Prints the version of SwiftPM being used.

## License

This repo is licensed under the MIT License. See the [LICENSE](LICENSE.md) file for rights and limitations.
