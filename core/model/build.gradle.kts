plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("kotlinx-serialization")
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}
