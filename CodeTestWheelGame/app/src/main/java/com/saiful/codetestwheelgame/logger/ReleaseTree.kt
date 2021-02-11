package com.saiful.codetestwheelgame.logger

import android.util.Log
import timber.log.Timber

/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */
class ReleaseTree : Timber.Tree() {
    override fun log(
        priority: Int,
        tag: String?,
        message: String,
        t: Throwable?
    ) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }
        // May send crash report to Firebase CrashAnalytics
        // FirebaseCrash.report(message);
        // FirebaseCrash.report(new Exception(message));
    }
}