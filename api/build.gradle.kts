plugins {
    id("kotlin-platform-common")
}

dependencies {
    implementation(kotlin("stdlib-common", "1.3.21"))
    implementation("org.jetbrains.kotlinx:kotlinx-io:0.1.7")

    testCompile("org.jetbrains.kotlin:kotlin-test-common:1.3.20")
    testCompile("org.jetbrains.kotlin:kotlin-test-annotations-common:1.3.20")
}