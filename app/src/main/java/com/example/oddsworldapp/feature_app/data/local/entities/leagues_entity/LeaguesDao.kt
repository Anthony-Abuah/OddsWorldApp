package com.example.oddsworldapp.feature_app.data.local.entities.leagues_entity

import androidx.room.*
import com.example.oddsworldapp.core.util.Constants.LeaguesTable
import com.example.oddsworldapp.feature_app.domain.repository.AllFootballLeagues
import kotlinx.coroutines.flow.Flow


@Dao
interface LeaguesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeagues(leagues: List<LeaguesEntity>)

    @Query ("DELETE FROM $LeaguesTable")
    suspend fun deleteLeagues()

    @Query ("SELECT * FROM $LeaguesTable WHERE theGroup LIKE :group")
    fun allLeagues(group: String): Flow<AllFootballLeagues>

    @Query ("SELECT * FROM $LeaguesTable WHERE theGroup LIKE :group")
    suspend fun getLeagues(group: String): List<LeaguesEntity>

    @Query ("SELECT key FROM $LeaguesTable")
    suspend fun getLeagueKeys(): List<String>

}