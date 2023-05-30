plugins {
    alias(libs.plugins.blossom)
}

dependencies {
    compileOnly(libs.velocity.api)
    annotationProcessor(libs.velocity.api)
    compileOnly(libs.miniplaceholders)
    implementation(projects.viaversionExpansionCommon)
}

blossom {
    replaceTokenIn("src/main/java/io/github/miniplaceholders/expansion/viaversion/velocity/Constants.java")
    replaceToken("{version}", project.version)
}
