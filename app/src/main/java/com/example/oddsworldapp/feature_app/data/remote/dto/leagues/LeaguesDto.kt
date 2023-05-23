package com.example.oddsworldapp.feature_app.data.remote.dto.leagues

import com.example.oddsworldapp.feature_app.data.local.entities.leagues_entity.LeaguesEntity
import com.example.oddsworldapp.feature_app.domain.model.leagues.Leagues

data class LeaguesDto(
    val active: Boolean,
    val description: String,
    val group: String,
    val has_outrights: Boolean,
    val key: String,
    val title: String
){
    fun  toLeagues(): Leagues{
        return Leagues(active, description, group, has_outrights, key, title)
    }

    fun  toLeaguesEntity(): LeaguesEntity{
        return LeaguesEntity(null, active, description, group, has_outrights, key, title)
    }
}