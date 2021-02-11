package com.saiful.codetestwheelgame.data.model


/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */
sealed class SpinWheelDataWrapper<out T> {
    data class Success<out T>(val data: T? = null) : SpinWheelDataWrapper<T>()
    data class Loading(val nothing: Nothing? = null) : SpinWheelDataWrapper<Nothing>()
    data class Failed(val message: String? = null) : SpinWheelDataWrapper<Nothing>()
    data class Exception(val message: String? = null) : SpinWheelDataWrapper<Nothing>()
}