plugins {
    kotlin("jvm") version "1.4.30"
    application
}

group = "com.yt8492"
version = "1.0.0"

application {
    mainClass.set("MainKt")
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}
