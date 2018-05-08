# 📝 SwiftPM Gradle Plugin CHANGELOG

## Unreleased

## 1.1.0

- ✨ Dependency tasks #24
   - `swiftpmShowDependencies` - Prints the resolved dependency graph.
   - `swiftpmResolve` - Resolves package dependencies.
   - `swiftpmUpdate` - Updates package dependencies.
- 🚨 Removed unused instance variables. #20
- ➕ ShellExec (1.1.3) #23

## 1.0.0

### 🎉 Initial Tasks

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

### Other

- ➕🔌 Add Clamp (1.0.0) #18
- 📝 Added 📦 emoji to task group. #15
- 🚰 [Tube](https://github.com/phatblat/Tube) #14
- ⬆️ Kotlin (1.2.31). #13
