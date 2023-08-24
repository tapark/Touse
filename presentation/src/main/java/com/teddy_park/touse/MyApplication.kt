package com.teddy_park.touse

import android.app.Application
import com.teddy_park.data.preference.PrefManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        PrefManager.init(applicationContext)
    }
}