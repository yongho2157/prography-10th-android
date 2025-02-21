plugins {
    alias(libs.plugins.prography.android.library)
    alias(libs.plugins.prography.hilt)
}

android {
    namespace = "com.example.prography_10th_android.core.data"
}

dependencies {
    api(projects.core.domain)
    api(projects.core.network)
    api(projects.core.database)

    implementation(libs.androidx.paging.runtime.ktx)
}

