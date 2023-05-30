dependencies {
    compileOnly(libs.paper.api)
    compileOnly(libs.miniplaceholders)
    implementation(projects.viaversionExpansionCommon)
}

tasks {
    processResources {
        filesMatching("paper-plugin.yml") {
            expand("version" to project.version)
        }
    }
}
