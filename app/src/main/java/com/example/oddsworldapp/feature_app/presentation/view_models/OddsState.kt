package com.example.oddsworldapp.feature_app.presentation.view_models

import com.example.oddsworldapp.feature_app.domain.model.odds.Odds


data class OddsState (
    val odds: List<Odds> = emptyList(),
    val isLoading: Boolean = false
)