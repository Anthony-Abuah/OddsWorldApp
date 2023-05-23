package com.example.oddsworldapp.feature_app.di

import android.app.Application
import androidx.room.Room
import com.example.oddsworldapp.feature_app.data.local.AppDatabase
import com.example.oddsworldapp.feature_app.data.local.Converters
import com.example.oddsworldapp.feature_app.data.util.GsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase{
        return Room.databaseBuilder(
            app, AppDatabase::class.java, "appDatabase"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

}