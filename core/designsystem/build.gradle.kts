plugins {
    alias(libs.plugins.decompose.android.library)
    alias(libs.plugins.decompose.android.library.compose)
}

android {
    namespace = "ru.pam.decompose.core.designsystem"
}

dependencies {
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)
}
