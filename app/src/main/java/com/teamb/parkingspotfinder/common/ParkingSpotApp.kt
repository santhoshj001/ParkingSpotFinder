package com.teamb.parkingspotfinder.common

import android.app.Application
import com.teamb.parkingspotfinder.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber.*
import timber.log.Timber.Forest.plant


@HiltAndroidApp
class ParkingSpotApp : Application(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            plant(DebugTree())
        } else {
            plant()
        }
    }
}