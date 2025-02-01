plugins {
    alias(libs.plugins.decompose.android.library)
}

android {
    namespace = "ru.pam.decompose.core.resources"
}

dependencies {
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.google.android.material)
}
