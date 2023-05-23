package com.example.oddsworldapp.feature_app.domain.repository

import com.example.oddsworldapp.core.util.Resource
import com.example.oddsworldapp.feature_app.data.local.entities.leagues_entity.LeaguesEntity
import com.example.oddsworldapp.feature_app.domain.model.leagues.Leagues
import kotlinx.coroutines.flow.Flow

interface LeaguesRepository {

    fun getLeagues(key: String, host: String, leagueKey:String): Flow<Resource<List<Leagues>>>

    fun allLeagues(): Flow<AllFootballLeagues>
}

typealias AllFootballLeagues = List<LeaguesEntity>