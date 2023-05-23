package com.example.oddsworldapp.feature_app.presentation.view_models

import com.example.oddsworldapp.feature_app.domain.model.odds.Bookmaker


data class BookmakerState (
    val bookmakers: List<Bookmaker> = emptyList(),
    val isLoading: Boolean = false
)