package com.example.oddsworldapp.feature_app.data.local.entities.scores_entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.oddsworldapp.core.util.Constants.ScoresTable
import com.example.oddsworldapp.feature_app.domain.model.scores.Score
import com.example.oddsworldapp.feature_app.domain.model.scores.Scores

@Entity(tableName = ScoresTable)
data class ScoresEntity(
    @PrimaryKey val oddsId: Int? = null,
    val away_team: String,
    val commence_time: String,
    val completed: Boolean,
    val home_team: String,
    val id: String,
    val last_update: String,
    val scores: List<Score>?,
    val sport_key: String,
    val sport_title: String
){
    fun toScores(): Scores {
        return Scores(away_team, commence_time, completed, home_team, id, last_update, scores, sport_key, sport_title
        )
    }

}
