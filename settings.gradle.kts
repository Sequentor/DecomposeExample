pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DecomposeExample"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")

include(":core:designsystem")
include(":core:resources")
include(":core:ui")

include(":feature:home")
include(":feature:main")
include(":feature:news")
include(":feature:profile")
include(":feature:root")
include(":feature:settings")
