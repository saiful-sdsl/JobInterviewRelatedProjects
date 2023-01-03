package com.ksu.kotlinassignmentraisethecloche

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ksu.kotlinassignmentraisethecloche.billings.Billings
import com.ksu.kotlinassignmentraisethecloche.course.Menu
import com.ksu.kotlinassignmentraisethecloche.course.MainMenu
import com.ksu.kotlinassignmentraisethecloche.course.StartersMenu
import com.ksu.kotlinassignmentraisethecloche.databinding.ActivityMainLayoutBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculateBill.setOnClickListener {
            processOrder()
        }
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