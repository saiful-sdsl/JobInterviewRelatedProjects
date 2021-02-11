package com.saiful.codetestwheelgame.usecase

import com.saiful.codetestwheelgame.data.model.SpinWheelDataWrapper
import com.saiful.codetestwheelgame.data.model.SpinWheelData
import com.saiful.codetestwheelgame.data.repository.SpinWheelDataRepository
import javax.inject.Inject


/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */

class RetrieveSpinWheelDataUseCase @Inject constructor(private val spinWheelDataRepository: SpinWheelDataRepository) {
    suspend fun getRewardDataList(): SpinWheelDataWrapper<SpinWheelData> {
        val spinWheelData = spinWheelDataRepository.getSpinWheelData()
        return if(!spinWheelData.isNullOrEmpty()) {
             SpinWheelDataWrapper.Success(spinWheelData)
        } else  SpinWheelDataWrapper.Failed("Something went wrong. please try again")
    }
}