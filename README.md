# SwiftPM Plugin

[![Tube](https://jenkins.log-g.co/buildStatus/icon?job=phatblat/SwiftPM-Plugin/master)](https://jenkins.log-g.co/job/phatblat/job/SwiftPM-Plugin/job/master/)
[![codebeat badge](https://codebeat.co/badges/7fcaa41d-d366-4904-8b7c-05ec91aebb85)](https://codebeat.co/projects/github-com-phatblat-swiftpm-plugin-master)
[![Kotlin 1.2.31](https://img.shields.io/badge/Kotlin-1.2.31-orange.svg?style=flat)](http://kotlinlang.org/)

Gradle plugin for the [Swift Package Manager](https://github.com/apple/swift-package-manager).

Note that only tools [version 4](https://github.com/apple/swift-package-manager/blob/master/Documentation/PackageDescriptionV4.md#packagedescription-api-version-4)
is supported.

TODO: Create gradle tasks for all remaining subcommands.

```
swift package --help                                                                                                                                                                                                                                                                             ⌚️ 13:44:36
OVERVIEW: Perform operations on Swift packages

USAGE: swift package [options] subcommand

OPTIONS:
  --build-path            Specify build/cache directory [default: ./.build]
  --configuration, -c     Build with configuration (debug|release) [default: debug]
  --disable-prefetching
  --disable-sandbox       Disable using the sandbox when executing subprocesses
  --enable-prefetching
  --no-static-swift-stdlib
                          Do not link Swift stdlib statically
  --package-path          Change working directory before any other operation
  --static-swift-stdlib   Link Swift stdlib statically
  --verbose, -v           Increase verbosity of informational output
  -Xcc                    Pass flag through to all C compiler invocations
  -Xcxx                   Pass flag through to all C++ compiler invocations
  -Xlinker                Pass flag through to all linker invocations
  -Xswiftc                Pass flag through to all Swift compiler invocations
  --help                  Display available options

SUBCOMMANDS:
  clean                   Delete build artifacts
  describe                Describe the current package
  dump-package            Print parsed Package.swift as JSON
  edit                    Put a package in editable mode
  generate-completion-script
                          Generate completion script (Bash or ZSH)
  generate-xcodeproj      Generates an Xcode project
  init                    Initialize a new package
  reset                   Reset the complete cache/build directory
  resolve                 Resolve package dependencies
  show-dependencies       Print the resolved dependency graph
  tools-version           Manipulate tools version of the current package
  unedit                  Remove a package from editable mode
  update                  Update package dependencies
```

## License

This repo is licensed under the MIT License. See the [LICENSE](LICENSE.md) file for rights and limitations.

# Gradle Version

TODO: Include minimum gradle version

The build script for this project uses Gradle 4.2 and Kotlin DSL version 0.11.1.
