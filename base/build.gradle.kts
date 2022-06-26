plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                AppConfig.proguardConsumerRules
            )
        }
        getByName("debug") {
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
}

dependencies {



    api(Android.ANDROID_CORE)
    api(Compose.COMPOSE_UI)
    api(Compose.COMPOSE_MATERIAL)
    api(Compose.COMPOSE_UI_PREVIEW)
    api(Lifecycle.ANDROID_LIFECYCLE)
    api(Compose.COMPOSE_ACTIVITY)
    api(Compose.COMPOSE_TOOLING_UI)
    api(Compose.COMPOSE_TEST_MANIFEST)
    api("androidx.activity:activity-ktx:1.4.0")
    api(Coroutines.COROUTINES_CORE)
    api(Coroutines.COROUTINES_ANDROID)


    //Android Test
    testImplementation(Junit.JUNIT)
    androidTestImplementation(Junit.JUNIT_EXT)
    androidTestImplementation(Espresso.ESPRESSO_CORE)

    //Hilt
    api(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)
    kapt(Hilt.hiltWorker)

    // Retrofit
    api(Retrofit.RETROFIT_LIB)
    api(Retrofit.GSON_CONVERTOR)
    api(Retrofit.INTERCEPTOR)
    api(Retrofit.SCALAR_CONVERTOR)
    api(Coil.COIL_IMAGE_UPLOAD)

}