plugins {
    alias(libs.plugins.decompose.android.feature)
}

android {
    namespace = "ru.pam.decompose.feature.profile"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.resources)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.material3)

    implementation(libs.bundles.decompose)
}
