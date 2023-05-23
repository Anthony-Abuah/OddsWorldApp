package com.example.oddsworldapp.feature_app.di

import com.example.oddsworldapp.core.util.Constants
import com.example.oddsworldapp.core.util.Constants.BASE_URL
import com.example.oddsworldapp.feature_app.data.remote.OddsWorldApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOddsWorldApi(): OddsWorldApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OddsWorldApi::class.java)
    }


}