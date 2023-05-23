package com.example.oddsworldapp.feature_app.domain.repository

import com.example.oddsworldapp.core.util.Resource
import com.example.oddsworldapp.feature_app.data.local.entities.odds_entity.OddsEntity
import com.example.oddsworldapp.feature_app.domain.model.leagues.Leagues
import com.example.oddsworldapp.feature_app.domain.model.odds.Odds
import kotlinx.coroutines.flow.Flow

interface OddsRepository {

    fun getOdds(key: String, host: String, league: String, sport: String, regions: String): Flow<Resource<List<Odds>>>

    fun getRoomOdds(): Flow<List<OddsEntity>>


}