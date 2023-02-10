package com.ksu.kotlintrendingtoolstutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val random = (Random.Math*10)
        println("Random no- ${}")
        MainScope().launch {
            println("Current Thread Name: ${Thread.currentThread()}")
            val receiver = producer()
            receiver.collect(){
                println("Received from producer: $it")
            }
        }
    }

    private fun producer(): Flow<String> =
        flow {
            val listOfData = listOf<String>("Saiful","Sharaban","Tahora","Bilash Saha")
            listOfData.forEach {
                delay(2000)
                emit(it)
            }

        }
}