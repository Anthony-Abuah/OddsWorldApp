package com.example.oddsworldapp.feature_app.data.remote.dto.odds

import com.example.oddsworldapp.feature_app.data.local.entities.odds_entity.OddsEntity
import com.example.oddsworldapp.feature_app.domain.model.odds.Odds

data class OddsDto(
    val away_team: String,
    val bookmakers: List<BookmakerDto>,
    val commence_time: String,
    val home_team: String,
    val id: String,
    val sport_key: String,
    val sport_title: String
){
    fun toOdds():Odds{
        return Odds(away_team, bookmakers.map { it.toBookmaker() }, commence_time, home_team, id, sport_key, sport_title
        )
    }

    fun toOddsEntity(): OddsEntity {
        return OddsEntity(null, away_team, bookmakers.map { it.toBookmaker() }, commence_time, home_team, id, sport_key, sport_title
        )
    }
}