package com.saiful.codetestwheelgame

import android.app.Application
import com.saiful.codetestwheelgame.logger.DebugTree
import com.saiful.codetestwheelgame.logger.ReleaseTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */
@HiltAndroidApp
class SpinWheelGameApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
        else Timber.plant(ReleaseTree())
    }
}