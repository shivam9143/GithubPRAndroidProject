package com.shivam.githubprs

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class PrApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }
}