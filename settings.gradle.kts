pluginManagement {

    includeBuild("build-logic")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))
rootProject.name = "prography-10th-android"
include(":app")
include(":core:network")
include(":core:model")
include(":core:data")
include(":core:common")
include(":core:domain")
include(":feature:home")
include(":core:designsystem")
include(":feature:detail")
include(":core:database")
include(":feature:random")
