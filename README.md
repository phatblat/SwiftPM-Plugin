# SwiftPM Plugin

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

