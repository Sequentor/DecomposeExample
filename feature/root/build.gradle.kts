plugins {
    alias(libs.plugins.decompose.android.feature)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ru.pam.decompose.feature.root"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.resources)

    implementation(projects.feature.main)
    implementation(projects.feature.settings)
    implementation(projects.feature.profile)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.material3)

    implementation(libs.bundles.decompose)
}
