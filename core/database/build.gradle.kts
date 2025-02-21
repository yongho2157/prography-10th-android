plugins {
    alias(libs.plugins.prography.android.library)
    alias(libs.plugins.prography.room)
    alias(libs.plugins.prography.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.prography_10th_android.core.database"
}

dependencies {
    api(projects.core.model)

    implementation(libs.kotlinx.serialization.json)
}
