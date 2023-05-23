package com.example.oddsworldapp.feature_app.domain.repository

import com.example.oddsworldapp.core.util.Resource
import com.example.oddsworldapp.feature_app.domain.model.leagues.Leagues
import com.example.oddsworldapp.feature_app.domain.model.scores.Scores
import kotlinx.coroutines.flow.Flow

interface ScoresRepository {

    fun getScores(key: String, host: String, league: String, sport: String): Flow<Resource<List<Scores>>>
}