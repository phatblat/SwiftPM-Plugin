# SwiftPM Plugin

[![Build Status](http://jenkins.log-g.co/buildStatus/icon?job=SwiftPM-Plugin)](http://jenkins.log-g.co/job/SwiftPM-Plugin/)
[![codebeat badge](https://codebeat.co/badges/7fcaa41d-d366-4904-8b7c-05ec91aebb85)](https://codebeat.co/projects/github-com-phatblat-swiftpm-plugin-master)
[![Kotlin 1.1.3](https://img.shields.io/badge/Kotlin-1.1.3-orange.svg?style=flat)](http://kotlinlang.org/)

Gradle plugin for the [Swift Package Manager](https://github.com/apple/swift-package-manager).

Note that only tools [version 4](https://github.com/apple/swift-package-manager/blob/master/Documentation/PackageDescriptionV4.md#packagedescription-api-version-4)
is supported.

```
swift package --help                                                                                                                                                                                                                                                                          ⌚️ 13:24:52
OVERVIEW: Perform operations on Swift packages

USAGE: swift package [options] subcommand

OPTIONS:
  --build-path           Specify build/cache directory [default: ./.build]
  --chdir, -C            Change working directory before any other operation
  --disable-sandbox      Disable using the sandbox when executing subprocesses
  --enable-prefetching   Enable prefetching in resolver
  --verbose, -v          Increase verbosity of informational output
  -Xcc                   Pass flag through to all C compiler invocations
  -Xlinker               Pass flag through to all linker invocations
  -Xswiftc               Pass flag through to all Swift compiler invocations
  --help                 Display available options

SUBCOMMANDS:
  clean                  Delete build artifacts
  describe               Describe the current package
  dump-package           Print parsed Package.swift as JSON
  edit                   Put a package in editable mode
  generate-xcodeproj     Generates an Xcode project
  init                   Initialize a new package
  reset                  Reset the complete cache/build directory
  resolve                Resolve package dependencies
  show-dependencies      Print the resolved dependency graph
  tools-version          Manipulate tools version of the current package
  unedit                 Remove a package from editable mode
  update                 Update package dependencies
```

## License

This repo is licensed under the MIT License. See the [LICENSE](LICENSE.md) file for rights and limitations.

# Gradle Version

The build script for this project uses Gradle Kotlin DSL (version 0.10.0?). The included Gradle wrapper was set to this pre-release version using the following command:

```
gradle wrapper --gradle-distribution-url https://repo.gradle.org/gradle/dist-snapshots/gradle-script-kotlin-4.1-20170615174816+0000-all.zip
```
