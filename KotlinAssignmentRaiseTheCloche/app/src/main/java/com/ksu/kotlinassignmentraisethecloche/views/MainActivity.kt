package com.ksu.kotlinassignmentraisethecloche.views

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ksu.kotlinassignmentraisethecloche.R
import com.ksu.kotlinassignmentraisethecloche.billings.Billings
import com.ksu.kotlinassignmentraisethecloche.course.Menu
import com.ksu.kotlinassignmentraisethecloche.course.MainMenu
import com.ksu.kotlinassignmentraisethecloche.course.StartersMenu
import com.ksu.kotlinassignmentraisethecloche.databinding.ActivityMainLayoutBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewSplashScreen()
        viewSplashScreenWithDelay()

        val binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculateBill.setOnClickListener {
            processOrder()
        }
    }

    private fun viewSplashScreenWithDelay() {
         val splashScreen = installSplashScreen()
        setDelayOnSplashScreen(splashScreen)
    }

    private fun viewSplashScreen() {
       installSplashScreen()
    }

    private fun setDelayOnSplashScreen(splashScreen: SplashScreen) {
        var keepSplashOnScreen = true
        val delay = 2000L
        splashScreen.setKeepOnScreenCondition { keepSplashOnScreen }
        Handler(Looper.getMainLooper()).postDelayed({ keepSplashOnScreen = false }, delay)
    }

    private fun processOrder() {
        val orderList = ArrayList<Menu>()
        orderList.add(Menu(StartersMenu.QUICK_BITES_NON_VEGETARIAN, 2))
        orderList.add(Menu(StartersMenu.SOUP_VEGETARIAN, 2))
        orderList.add(Menu(MainMenu.NOODLES_VEGETARIAN, 2))
        calculateBill(orderList)
    }

    private fun calculateBill(orderList: ArrayList<Menu>) {
        Billings("Saiful", orderList).calculateBill()
    }
}