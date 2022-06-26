buildscript {

    allprojects {
        repositories {
            google()
            mavenCentral()
            jcenter()
            maven { url = uri("https://jitpack.io") }
            maven { url = uri("https://jcenter.bintray.com") }
        }
    }
}

tasks.register("clean").configure {
    delete("build")
}