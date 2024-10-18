plugins {
    kotlin("jvm") version "1.8.0"
    `java-library`
    `maven-publish`
}

group = "com.codergm"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "ostore-common-model"
        }
    }
    repositories {
        maven {
            // Target the local Maven repository (C:\Users\Idris\.m2\repository)
            url = uri("file://${System.getProperty("user.home")}/.m2/repository")
        }
    }
}
