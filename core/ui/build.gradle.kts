plugins {
    alias(libs.plugins.decompose.android.library)
    alias(libs.plugins.decompose.android.library.compose)
}

android {
    namespace = "ru.pam.decompose.core.ui"
}

dependencies {
    implementation(projects.core.designsystem)

    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.material.icons.extended)
}
