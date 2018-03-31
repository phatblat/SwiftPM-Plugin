package at.phatbl.swiftpm

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Container for version information.
 */
object Version {
    /** File inside the JAR which contains the version number. */
    private const val fileName = "VERSION.txt"

    /** Accessor property for version string. */
    val text: String
        get() {
            return try {
                val stream = javaClass.classLoader.getResourceAsStream(fileName)
                val txtReader = BufferedReader(InputStreamReader(stream))
                txtReader.readLine()
            } catch (exception: Exception) {
                println(exception.localizedMessage)
                "?"
            }
        }
}
