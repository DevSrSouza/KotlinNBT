plugins {
    kotlin("multiplatform") version "1.3.31"
    id("maven-publish")
}

group = "br.com.devsrsouza.${project.name.toLowerCase()}"
version = "1.0.0-SNAPSHOT"

allprojects {
    repositories {
        jcenter()
    }
}

kotlin {
    targets {
        jvm {
            mavenPublication { artifactId = "jvm" }
        }
    }
    (publishing.publications["metadata"] as MavenPublication).apply {
        artifactId = "api"
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common", "1.3.31"))
                implementation("org.jetbrains.kotlinx:kotlinx-io:0.1.7")
            }

        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8", "1.3.31"))
                implementation("org.jetbrains.kotlinx:kotlinx-io-jvm:0.1.7")
            }
        }
    }
}