package com.example.oddsworldapp.feature_app.data.remote.dto.odds

import com.example.oddsworldapp.feature_app.domain.model.odds.Outcome

data class OutcomeDto(
    val name: String,
    val price: Double
){
    fun toOutcome(): Outcome{
        return Outcome(name, price)
    }
}