plugins {
    alias(libs.plugins.prography.android.library)
    alias(libs.plugins.prography.hilt)
}

android {
    namespace = "com.example.prography_10th_android.core.domain"
}

dependencies {
    api(projects.core.common)
    api(projects.core.model)

    implementation(libs.androidx.paging.runtime.ktx)
}
