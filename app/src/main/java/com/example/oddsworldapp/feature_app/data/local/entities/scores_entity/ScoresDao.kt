package com.example.oddsworldapp.feature_app.data.local.entities.scores_entity

import androidx.room.*
import com.example.oddsworldapp.core.util.Constants.ScoresTable


@Dao
interface ScoresDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScores(odds: List<ScoresEntity>)

    @Query ("DELETE FROM $ScoresTable")
    suspend fun deleteScores()

    @Query ("SELECT * FROM $ScoresTable")
    suspend fun getScores(): List<ScoresEntity>

    @Query ("SELECT * FROM $ScoresTable WHERE sport_key LIKE :sport_key")
    suspend fun getScores(sport_key: String): List<ScoresEntity>

}