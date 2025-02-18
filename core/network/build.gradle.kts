plugins {
    alias(libs.plugins.prography.android.library)
    alias(libs.plugins.prography.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.prography_10th_android.core.network"
}

dependencies {
    api(projects.core.model)

    implementation(libs.retrofit.core)
    implementation(libs.okhttp.logging)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlin.serialization)
}
