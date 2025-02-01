plugins {
    alias(libs.plugins.decompose.android.feature)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ru.pam.decompose.feature.main"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.resources)

    implementation(projects.feature.home)
    implementation(projects.feature.news)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.material.icons.extended)

    implementation(libs.bundles.decompose)
}
