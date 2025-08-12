plugins {
    java
}

dependencies {
    compileOnly(libs.miniplaceholders)
    compileOnly(libs.viaversion)
    compileOnly(libs.adventure.api)
    compileOnly(libs.adventure.minimessage)
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.viaversion.com")
    maven("https://central.sonatype.com/repository/maven-snapshots/")
}
java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))
tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(21)
    }
}
