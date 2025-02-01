plugins {
    alias(libs.plugins.decompose.android.application)
}

android {
    defaultConfig {
        applicationId = "ru.pam.decompose"
        versionCode = 1
        versionName = "0.0.1"
    }

    buildTypes {
        debug {
            versionNameSuffix = ".debug"
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    namespace = "ru.pam.decompose"
}

dependencies {
    implementation(projects.core.resources)

    implementation(projects.feature.root)
}