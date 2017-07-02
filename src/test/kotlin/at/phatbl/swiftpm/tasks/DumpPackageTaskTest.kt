package at.phatbl.swiftpm.tasks


import kotlin.test.*
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test
//import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

//@RunWith(JUnitPlatform::class)
class DumpPackageTaskTest {
    val clazz: Class<DumpPackageTask> = DumpPackageTask::class.java
    var project: Project = ProjectBuilder.builder().build()
    var task: Task = project.tasks.create("swiftpmDumpPackage", clazz)

    @Before
    fun beforeEachTest() {
        project = ProjectBuilder.builder().build()
        task = project.tasks.create("swiftpmDumpPackage", clazz)
    }

    @Test
    fun `can be added to project`() {
        assertNotNull(task)
        assertTrue { task is DumpPackageTask }
    }
}
