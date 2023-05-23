package com.example.oddsworldapp.feature_app.presentation.view_models

import com.example.oddsworldapp.feature_app.domain.model.scores.Scores


data class ScoresState (
    val scores: List<Scores> = emptyList(),
    val isLoading: Boolean = false
)