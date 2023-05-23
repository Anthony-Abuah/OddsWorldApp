package com.example.oddsworldapp.feature_app.data.remote.dto.sores

import com.example.oddsworldapp.feature_app.domain.model.scores.Score

data class ScoreDto(
    val name: String,
    val score: String
){

    fun toScore(): Score{
        return Score(name, score)
    }
}