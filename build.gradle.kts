plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "com.nexus"
version = "1.0"

application {
    mainClass.set("com.nexus.nexus.Main")
}

repositories {
    mavenCentral()
}

javafx {
    version = "21"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    implementation("org.xerial:sqlite-jdbc:3.45.3.0")
    implementation("org.mindrot:jbcrypt:0.4")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
}