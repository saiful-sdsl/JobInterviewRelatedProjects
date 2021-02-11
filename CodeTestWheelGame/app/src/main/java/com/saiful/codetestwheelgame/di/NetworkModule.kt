package com.saiful.codetestwheelgame.di

import com.saiful.codetestwheelgame.data.service.SpinWheelDataService
import com.saiful.codetestwheelgame.utils.NetworkConstants.BASE_SERVER_URL
import com.saiful.codetestwheelgame.utils.NetworkConstants.REQUEST_TIMEOUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseServerUrl(): String {
        return BASE_SERVER_URL
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .callTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .build()

    @Provides
    fun provideRetrofit(baseURL: String, okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    fun provideRewardService(retrofit: Retrofit): SpinWheelDataService =
        retrofit.create(SpinWheelDataService::class.java)

}