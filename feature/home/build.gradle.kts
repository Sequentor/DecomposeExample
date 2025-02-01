plugins {
    alias(libs.plugins.decompose.android.feature)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ru.pam.decompose.feature.home"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.resources)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.material3)

    implementation(libs.bundles.decompose)
}
