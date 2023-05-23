package com.example.oddsworldapp.feature_app.presentation.view_models

import com.example.oddsworldapp.feature_app.domain.model.leagues.Leagues


data class LeaguesState (
    val leagues: List<Leagues> = emptyList(),
    val isLoading: Boolean = false
)