package com.example.oddsworldapp.feature_app.data.local.entities.odds_entity

import androidx.room.*
import com.example.oddsworldapp.core.util.Constants.OddsTable
import kotlinx.coroutines.flow.Flow


@Dao
interface OddsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOdds(odds: List<OddsEntity>)

    @Query ("DELETE FROM $OddsTable")
    suspend fun deleteOdds()

    @Query ("SELECT * FROM $OddsTable")
    suspend fun getOdds(): List<OddsEntity>

    @Query ("SELECT * FROM $OddsTable")
    fun getRoomOdds(): Flow<List<OddsEntity>>

    @Query ("SELECT * FROM $OddsTable WHERE sport_key LIKE :sport_key ")
    suspend fun getOdds(sport_key: String): List<OddsEntity>

}