package com.example.oddsworldapp.feature_app.domain.model.scores

data class Scores(
    val away_team: String,
    val commence_time: String,
    val completed: Boolean,
    val home_team: String,
    val id: String,
    val last_update: String,
    val scores: List<Score>?,
    val sport_key: String,
    val sport_title: String
)