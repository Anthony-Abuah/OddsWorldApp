package com.example.oddsworldapp.feature_app.domain.model.odds

data class Odds(
    val away_team: String,
    val bookmakers: List<Bookmaker>,
    val commence_time: String,
    val home_team: String,
    val id: String,
    val sport_key: String,
    val sport_title: String
)