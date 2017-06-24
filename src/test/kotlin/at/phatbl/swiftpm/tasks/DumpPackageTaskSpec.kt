package at.phatbl.swiftpm.tasks

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

//import org.junit.runner.RunWith
//import org.junit.platform.runner.JUnitPlatform

// JUnit 4
//@RunWith(JUnitPlatform::class)
object DumpPackageTaskSpec: Spek({
    describe("a calculator") {
        on("addition") {
            val sum = 6

            it("should return the result of adding the first number to the second number") {
                assertEquals(6, sum)
            }
        }
    }
})
