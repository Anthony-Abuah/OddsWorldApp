package com.example.oddsworldapp.feature_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.oddsworldapp.feature_app.data.local.entities.leagues_entity.LeaguesDao
import com.example.oddsworldapp.feature_app.data.local.entities.leagues_entity.LeaguesEntity
import com.example.oddsworldapp.feature_app.data.local.entities.odds_entity.OddsDao
import com.example.oddsworldapp.feature_app.data.local.entities.odds_entity.OddsEntity
import com.example.oddsworldapp.feature_app.data.local.entities.scores_entity.ScoresDao
import com.example.oddsworldapp.feature_app.data.local.entities.scores_entity.ScoresEntity

@Database(
    entities = [LeaguesEntity::class, OddsEntity::class, ScoresEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract val leaguesDao: LeaguesDao
    abstract val oddsDao: OddsDao
    abstract val scoresDao: ScoresDao
}