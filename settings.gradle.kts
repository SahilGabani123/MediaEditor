pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        flatDir {
            dirs("libs")
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.arthenica.com/release") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        flatDir {
            dirs("libs")
        }
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.arthenica.com/release") }
        mavenCentral()
    }
}

rootProject.name = "MediaEditor"
include(":app")
include(":videcrop")
