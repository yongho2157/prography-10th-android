plugins {
    alias(libs.plugins.prography.android.library)
    alias(libs.plugins.prography.android.library.compose)
    alias(libs.plugins.prography.hilt)
    alias(libs.plugins.compose)
}

android {
    namespace = "com.example.prography_10th_android.feature.home"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(projects.core.domain)

    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose)
}
