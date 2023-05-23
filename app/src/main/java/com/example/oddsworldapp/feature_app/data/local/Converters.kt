package com.example.oddsworldapp.feature_app.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.oddsworldapp.feature_app.data.util.JsonParser
import com.example.oddsworldapp.feature_app.domain.model.odds.Bookmaker
import com.example.oddsworldapp.feature_app.domain.model.odds.Market
import com.example.oddsworldapp.feature_app.domain.model.odds.Outcome
import com.example.oddsworldapp.feature_app.domain.model.scores.Score
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromBookmakerJson(json: String): List<Bookmaker>{
        return jsonParser.fromJson<ArrayList<Bookmaker>>(
            json,
            object : TypeToken<ArrayList<Bookmaker>>(){}.type) ?: emptyList()
    }

    @TypeConverter
    fun toBookmakerJson(bookmaker: List<Bookmaker>): String{
        return jsonParser.toJson(
            bookmaker,
            object : TypeToken<ArrayList<Bookmaker>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromMarketJson(json: String): List<Market>{
        return jsonParser.fromJson<ArrayList<Market>>(
            json,
            object : TypeToken<ArrayList<Market>>(){}.type) ?: emptyList()
    }

    @TypeConverter
    fun toMarketJson(market: List<Market>): String{
        return jsonParser.toJson(
            market,
            object : TypeToken<ArrayList<Market>>(){}.type
        ) ?: "[]"
    }


    @TypeConverter
    fun fromOutcomeJson(json: String): List<Outcome>{
        return jsonParser.fromJson<ArrayList<Outcome>>(
            json,
            object : TypeToken<ArrayList<Outcome>>(){}.type) ?: emptyList()
    }

    @TypeConverter
    fun toOutcomeJson(outcome: List<Outcome>): String{
        return jsonParser.toJson(
            outcome,
            object : TypeToken<ArrayList<Outcome>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromScoreJson(json: String): List<Score>{
        return jsonParser.fromJson<ArrayList<Score>>(
            json,
            object : TypeToken<ArrayList<Score>>(){}.type) ?: emptyList()
    }

    @TypeConverter
    fun toScoreJson(score: List<Score>): String{
        return jsonParser.toJson(
            score,
            object : TypeToken<ArrayList<Score>>(){}.type
        ) ?: "[]"
    }

}