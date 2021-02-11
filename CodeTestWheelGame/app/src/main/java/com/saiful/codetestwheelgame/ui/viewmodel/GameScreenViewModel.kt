package com.saiful.codetestwheelgame.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.saiful.codetestwheelgame.data.model.SpinWheelDataWrapper
import com.saiful.codetestwheelgame.data.model.SpinWheelData
import com.saiful.codetestwheelgame.usecase.RetrieveSpinWheelDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */

@HiltViewModel
class GameScreenViewModel @Inject constructor(private val retrieveSpinWheelDataUseCase: RetrieveSpinWheelDataUseCase): ViewModel() {

    fun getSpinWheelData(): LiveData<SpinWheelDataWrapper<SpinWheelData>> {
        return liveData {
            emit(SpinWheelDataWrapper.Loading())
            emit(retrieveSpinWheelDataUseCase.getRewardDataList())
        }
    }
}