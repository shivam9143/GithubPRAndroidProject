import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:7.2.1")
    implementation(kotlin("gradle-plugin", "1.6.10"))
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.40.3")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.6.10")
//    implementation("com.google.gms:google-services:4.3.12")
}
