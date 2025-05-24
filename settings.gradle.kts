enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ViaVersion-Expansion"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

arrayOf("common", "paper", "velocity").forEach {
    include("viaversion-expansion-$it")

    project(":viaversion-expansion-$it").projectDir = file(it)
}

