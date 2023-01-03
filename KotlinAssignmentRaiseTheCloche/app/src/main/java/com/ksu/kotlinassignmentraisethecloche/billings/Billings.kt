package com.ksu.kotlinassignmentraisethecloche.billings

import android.os.Build
import android.util.Log
import com.ksu.kotlinassignmentraisethecloche.course.Menu
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Billings(private val customerName: String, private val purchasedItems: ArrayList<Menu>) {

    companion object {
        private var billID: Int = 0
    }

    private val serviceTaxPercent = 5
    private var totalAmountBeforeTax = 0.0
    private var totalAmountAfterTax = 0.0


    private val dateOfPurchase: String = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        current.format(formatter)
    } else {
        "Invalid date"
    }

    fun calculateBill() {
        println("######### Raise the Cloche #########")
        println("Date: $dateOfPurchase")
        println("Bill ID: ${++billID}")
        println("Customer Name : $customerName")
        println("-----------------------------")
        println("Items\t\t\t\t\t\t\t\t\t\t\tQuantity\t\t\t\t\t\tPrice")
        for (course in purchasedItems) {
            print(course.menuItem.itemName)
            val calculateLength = 30 - course.menuItem.itemName.length
            for (i in 1..calculateLength) print(" ")
            print("\t\t\t\t\t\t${course.quantity}\t\t\t\t\t\t\t${(course.menuItem.price * course.quantity)}")
            totalAmountBeforeTax += (course.menuItem.price * course.quantity)
            print("\n")
        }
        println("Total before Tax =\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$totalAmountBeforeTax")
        println("Total Tax $serviceTaxPercent% =\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t${(totalAmountBeforeTax * serviceTaxPercent) / 100}")
        totalAmountAfterTax =
            totalAmountBeforeTax + ((totalAmountBeforeTax * serviceTaxPercent) / 100)
        Log.d("Billings","Total [${purchasedItems.size}] items and Due = \t\t\t\t\t\t\t\t\t\t\t\t\t\t$totalAmountAfterTax")

        println("######### **** #########")
    }

}