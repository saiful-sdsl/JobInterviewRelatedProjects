package com.saiful.codetestwheelgame.di

import com.saiful.codetestwheelgame.data.repository.SpinWheelDataRepository
import com.saiful.codetestwheelgame.usecase.RetrieveSpinWheelDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */


@InstallIn(ActivityRetainedComponent:: class)
@Module
object UseCaseModule {
    @Provides
    fun providesRewardDataUseCase(spinWheelDataRepository: SpinWheelDataRepository): RetrieveSpinWheelDataUseCase {
        return RetrieveSpinWheelDataUseCase(spinWheelDataRepository)
    }
}