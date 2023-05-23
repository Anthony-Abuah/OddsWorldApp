package com.example.oddsworldapp.feature_app.data.remote.dto.odds

import com.example.oddsworldapp.feature_app.domain.model.odds.Market

data class MarketDto(
    val key: String,
    val last_update: String,
    val outcomes: List<OutcomeDto>
){
    fun toMarket(): Market{
        return Market(key,last_update, outcomes.map { it.toOutcome() })
    }
}