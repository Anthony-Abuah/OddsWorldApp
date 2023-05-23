package com.example.oddsworldapp.feature_app.domain.model.leagues

data class Leagues(
    val active: Boolean,
    val description: String,
    val group: String,
    val has_outrights: Boolean,
    val key: String,
    val title: String
)