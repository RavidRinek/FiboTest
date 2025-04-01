package com.test.fibotest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FiboApp : Application(){

    override fun onCreate() {
        super.onCreate()
    }
}