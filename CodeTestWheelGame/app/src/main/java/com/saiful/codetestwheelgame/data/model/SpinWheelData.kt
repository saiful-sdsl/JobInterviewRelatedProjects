package com.saiful.codetestwheelgame.data.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */
class SpinWheelData : ArrayList<SpinWheelData.RewardsItem>() {
    data class RewardsItem(
        @SerializedName("currency")
        val currency: String,
        @SerializedName("displayText")
        val displayText: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("value")
        val value: Int
    )
}