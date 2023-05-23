package com.example.oddsworldapp.feature_app.data.local.entities.leagues_entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.oddsworldapp.core.util.Constants.LeaguesTable
import com.example.oddsworldapp.feature_app.domain.model.leagues.Leagues

@Entity(tableName = LeaguesTable)
data class LeaguesEntity(
    @PrimaryKey val leaguesId: Int? = null,
    val active: Boolean,
    val description: String,
    val theGroup: String,
    val has_outrights: Boolean,
    val key: String,
    val title: String
){
    fun  toLeagues(): Leagues {
        return Leagues(active, description, theGroup, has_outrights, key, title)
    }
}
