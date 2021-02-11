package com.saiful.codetestwheelgame.data.repository

import com.saiful.codetestwheelgame.data.model.SpinWheelData
import com.saiful.codetestwheelgame.data.service.SpinWheelDataService
import javax.inject.Inject


/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */
class SpinWheelDataRepository @Inject constructor(private val spinWheelDataService: SpinWheelDataService) {
    suspend fun getSpinWheelData(): SpinWheelData {
        return spinWheelDataService.getSpinWheelData()
    }
}