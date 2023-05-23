package com.example.oddsworldapp.feature_app.domain.model.odds

data class Bookmaker(
    val key: String,
    val last_update: String,
    val markets: List<Market>,
    val title: String
)