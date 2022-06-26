object Gradle {
    val GRADLE_DEPENDENCY = "com.android.tools.build:gradle:" + Versions.GRADLE_VERSION
}

object DaggerHilt {
    val DAGGER_HILT_GRADLE_PLUGIN_DEPENDENCY =
        "com.google.dagger:hilt-android-gradle-plugin" + Versions.DAGGER_HILT_GRADLE
}

object Hilt {
    val hiltAndroid = "com.google.dagger:hilt-android:" + Versions.HILT_VERSION
    val hiltCompiler = "com.google.dagger:hilt-compiler:" + Versions.HILT_VERSION
    val hiltWorker = "androidx.hilt:hilt-work:1.0.0"
}


object Kotlin {
    val KOTLIN_SERIALIZER = "org.jetbrains.kotlin:kotlin-serialization" + Versions.KOTLIN_SERIALIZER
}

object Junit {
    val JUNIT = "junit:junit:" + Versions.JUNIT
    val JUNIT_EXT = "androidx.test.ext:junit:" + Versions.JUNIT_EXT
}

object Espresso {
    val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:" + Versions.ESPRESSO
}

object Android {
    val ANDROID_CORE = "androidx.core:core-ktx:" + Versions.ANDROID_CORE
}

object Coroutines {
    val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
}

object Lifecycle {
    val ANDROID_LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.LIFECYCLE_RUNTIME
    val LIFECYCLE_VIEWMODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    val LIFECYCLE_LIVEDATA =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"
}

object Compose {
    val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"
    val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
    val COMPOSE_FOUNDATION_LAYOUT =
        "androidx.compose.foundation:foundation-layout:${Versions.COMPOSE}"
    val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
    val COMPOSE_RUNTIME_LIVEDATA =
        "androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE}"
    val COMPOSE_UI_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    val COMPOSE_TOOLING_UI = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.COMPOSE}"
    val COMPOSE_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE}"
    val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    val COMPOSE_MATERIAL_THEME_ADAPTER = "com.google.android.material:compose-theme-adapter:1.1.5"
}

object Retrofit {
    val RETROFIT_LIB = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    val GSON_CONVERTOR = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    val INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.INTERCEPTOR}"
    val SCALAR_CONVERTOR = "com.squareup.retrofit2:converter-scalars:${Versions.RETROFIT_SCALAR}"
}

object Coil {
    val COIL_IMAGE_UPLOAD = "com.google.accompanist:accompanist-coil:${Versions.COIL}"
}

object PAGING {
    val PAGING_COMPOSE = "androidx.paging:paging-compose:${Versions.PAGING_COMPOSE}"
}