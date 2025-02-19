import com.android.build.api.dsl.LibraryExtension
import com.example.prography_10th_android.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)

            dependencies {
                val bom = libs.findLibrary("androidx-compose-bom").get()
                add("implementation", platform(bom))
                add("androidTestImplementation", platform(bom))

                add("implementation", libs.findLibrary("androidx.material3").get())
                add("implementation", libs.findLibrary("androidx-ui").get())
                add("implementation", libs.findLibrary("androidx.ui.tooling.preview").get())
                add("androidTestImplementation", libs.findLibrary("androidx.junit").get())
                add(
                    "androidTestImplementation",
                    libs.findLibrary("androidx.espresso.core").get()
                )
                add(
                    "androidTestImplementation",
                    libs.findLibrary("androidx.ui.test.junit4").get()
                )
                add("debugImplementation", libs.findLibrary("androidx.ui.tooling").get())
                add("debugImplementation", libs.findLibrary("androidx.ui.test.manifest").get())
            }
        }
    }
}


internal fun configureAndroidCompose(
    commonExtension: LibraryExtension
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}
