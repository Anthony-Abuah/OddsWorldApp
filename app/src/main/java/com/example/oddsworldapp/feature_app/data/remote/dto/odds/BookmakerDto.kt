package com.example.oddsworldapp.feature_app.data.remote.dto.odds

import com.example.oddsworldapp.feature_app.domain.model.odds.Bookmaker

data class BookmakerDto(
    val key: String,
    val last_update: String,
    val markets: List<MarketDto>,
    val title: String
){
    fun toBookmaker(): Bookmaker{
        return Bookmaker(key,last_update,markets.map { it.toMarket() }, title)
    }
}