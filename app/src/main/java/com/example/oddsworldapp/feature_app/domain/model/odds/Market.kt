package com.example.oddsworldapp.feature_app.domain.model.odds

data class Market(
    val key: String,
    val last_update: String,
    val outcomes: List<Outcome>
)