package com.example.oddsworldapp.feature_app.data.local.entities.odds_entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.oddsworldapp.core.util.Constants.OddsTable
import com.example.oddsworldapp.feature_app.domain.model.odds.Bookmaker
import com.example.oddsworldapp.feature_app.domain.model.odds.Odds

@Entity(tableName = OddsTable)
data class OddsEntity(
    @PrimaryKey val oddsId: Int? = null,
    val away_team: String,
    val bookmakers: List<Bookmaker>,
    val commence_time: String,
    val home_team: String,
    val id: String,
    val sport_key: String,
    val sport_title: String
){
    fun toOdds(): Odds {
        return Odds(away_team, bookmakers, commence_time, home_team, id, sport_key, sport_title
        )
    }

}
