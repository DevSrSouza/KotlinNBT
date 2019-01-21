import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.3.11"
}

group = "br.com.devsrsouza"
version = "1.0-SNAPSHOT"


allprojects {
    repositories {
        jcenter()
    }
}

kotlin {
    targets {

    }
}