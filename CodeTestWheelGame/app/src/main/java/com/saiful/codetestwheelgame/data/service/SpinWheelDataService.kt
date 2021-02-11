package com.saiful.codetestwheelgame.data.service

import com.saiful.codetestwheelgame.data.model.SpinWheelData
import com.saiful.codetestwheelgame.utils.NetworkConstants
import retrofit2.http.GET


/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */
interface SpinWheelDataService {
    @GET(NetworkConstants.URL_REPOSITORY)
    suspend fun getSpinWheelData(): SpinWheelData
}