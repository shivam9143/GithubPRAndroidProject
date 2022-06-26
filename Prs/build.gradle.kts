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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

//    implementation("androidx.appcompat:appcompat:1.4.2")
//    implementation("com.google.android.material:material:1.6.1")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation(Compose.COMPOSE_ACTIVITY)


    //Android Test
    testImplementation(Junit.JUNIT)
    androidTestImplementation(Junit.JUNIT_EXT)
    androidTestImplementation(Espresso.ESPRESSO_CORE)

    //Hilt
    api(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)
    kapt(Hilt.hiltWorker)

    api(project(":base"))

    implementation(Lifecycle.LIFECYCLE_VIEWMODEL)
    implementation(Lifecycle.LIFECYCLE_LIVEDATA)

    // Retrofit
    api(Retrofit.RETROFIT_LIB)
    api(Retrofit.GSON_CONVERTOR)
    api(Retrofit.INTERCEPTOR)
    api(Retrofit.SCALAR_CONVERTOR)


    implementation(PAGING.PAGING_COMPOSE)

}