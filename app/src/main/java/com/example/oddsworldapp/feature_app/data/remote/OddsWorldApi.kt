package com.example.oddsworldapp.feature_app.data.remote

import com.example.oddsworldapp.core.util.Constants.Header_Host
import com.example.oddsworldapp.core.util.Constants.Header_Key
import com.example.oddsworldapp.feature_app.data.remote.dto.leagues.LeaguesDto
import com.example.oddsworldapp.feature_app.data.remote.dto.odds.OddsDto
import com.example.oddsworldapp.feature_app.data.remote.dto.sores.ScoresDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface OddsWorldApi {

    @GET("/v4/sports")
    suspend fun getSportLeagues(
        @Header(Header_Key) key: String,
        @Header(Header_Host) host: String
    ): List<LeaguesDto>


    @GET("/v4/sports/{league}/odds")
    suspend fun getOdds(
        @Header(Header_Key) key: String,
        @Header(Header_Host) host: String,
        @Path("league") league: String,
        @Query("sport") sport: String,
        @Query("regions") regions: String
    ): List<OddsDto>


    @GET("/v4/sports/{league}/scoreDtos")
    suspend fun getScores(
        @Header(Header_Key) key: String,
        @Header(Header_Host) host: String,
        @Path("league") league: String,
        @Query("sport") sport: String,
    ): List<ScoresDto>


}