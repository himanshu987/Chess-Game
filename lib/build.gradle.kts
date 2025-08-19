plugins {
    `java-library`
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(18)
    }
}

application {
    mainClass.set("org.example.ChessApplication")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
