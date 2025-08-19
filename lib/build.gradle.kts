plugins {
    `java-library`
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(18)
    }
}

application {
    mainClass.set("com.chess.ChessApplication")
}

tasks.test {
    useJUnitPlatform()
}