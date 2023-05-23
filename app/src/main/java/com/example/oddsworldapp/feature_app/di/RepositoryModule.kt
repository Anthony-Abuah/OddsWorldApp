package com.example.oddsworldapp.feature_app.di

import com.example.oddsworldapp.feature_app.data.local.AppDatabase
import com.example.oddsworldapp.feature_app.data.remote.OddsWorldApi
import com.example.oddsworldapp.feature_app.data.repository.LeaguesRepositoryImpl
import com.example.oddsworldapp.feature_app.data.repository.OddsRepositoryImpl
import com.example.oddsworldapp.feature_app.data.repository.ScoresRepositoryImpl
import com.example.oddsworldapp.feature_app.domain.repository.LeaguesRepository
import com.example.oddsworldapp.feature_app.domain.repository.OddsRepository
import com.example.oddsworldapp.feature_app.domain.repository.ScoresRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideScoresRepository(
        db: AppDatabase,
        api: OddsWorldApi
    ): ScoresRepository{
        return ScoresRepositoryImpl(api, db.scoresDao)
    }


    @Provides
    @Singleton
    fun provideLeaguesRepository(
        db: AppDatabase,
        api: OddsWorldApi
    ): LeaguesRepository{
        return LeaguesRepositoryImpl(api, db.leaguesDao)
    }


    @Provides
    @Singleton
    fun provideOddsRepository(
        db: AppDatabase,
        api: OddsWorldApi
    ): OddsRepository{
        return OddsRepositoryImpl(api, db.oddsDao)
    }


}