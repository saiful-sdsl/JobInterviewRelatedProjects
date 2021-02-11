package com.saiful.codetestwheelgame.logger

import timber.log.Timber

/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */
class DebugTree : Timber.Tree() {
    override fun log(
        priority: Int,
        tag: String?,
        message: String,
        t: Throwable?
    ) {
        // May send crash report to Firebase CrashAnalytics
        // FirebaseCrash.report(message);
        // FirebaseCrash.report(new Exception(message));
    }
}