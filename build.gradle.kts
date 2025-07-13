plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "dev.timdblt"
version = "1.0-dev1"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.flowarg.fr/repository/releases/")
    }
}

dependencies {
    // FlowUpdater
    implementation("fr.flowarg:flowupdater:1.7.4")

    // JavaFX (handled by plugin, but you can also add manual dependencies if needed)
    // implementation("org.openjfx:javafx-controls:21")
    // implementation("org.openjfx:javafx-fxml:21")

    // Test dependencies
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

javafx {
    version = "21"
    modules("javafx.controls", "javafx.fxml")
}

tasks.test {
    useJUnitPlatform()
}

// Optional: Configure the main class for the application plugin
application {
    mainClass.set("dev.timdblt.Main") // Replace with your actual main class
}