package com.example.oddsworldapp.feature_app.data.repository

import com.example.oddsworldapp.core.util.Constants.Football
import com.example.oddsworldapp.core.util.Resource
import com.example.oddsworldapp.feature_app.data.local.entities.leagues_entity.LeaguesDao
import com.example.oddsworldapp.feature_app.data.remote.OddsWorldApi
import com.example.oddsworldapp.feature_app.domain.model.leagues.Leagues
import com.example.oddsworldapp.feature_app.domain.repository.AllFootballLeagues
import com.example.oddsworldapp.feature_app.domain.repository.LeaguesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class LeaguesRepositoryImpl(
    private val oddsWorldApi: OddsWorldApi,
    private val leaguesDao: LeaguesDao
): LeaguesRepository {
    override fun getLeagues(key: String, host: String, leagueKey: String): Flow<Resource<List<Leagues>>> = flow{
        emit(Resource.Loading())

        val leagues = leaguesDao.getLeagues(Football).map{it.toLeagues()}
        emit(Resource.Loading(data = leagues))

        try {
            val leagueKeys = leaguesDao.getLeagueKeys()
           if (!leagueKeys.contains(leagueKey)) {
                val remoteLeagues = oddsWorldApi.getSportLeagues(key, host)
                leaguesDao.deleteLeagues()
                leaguesDao.insertLeagues(remoteLeagues.map { it.toLeaguesEntity() })
           }
        }catch (e: HttpException){
            emit(Resource.Error(
                message = "Something went wrong",
                data = leagues
            ))
        }catch (e: IOException){
            emit(Resource.Error(
                message = "Couldn't connect to the server",
                data = leagues
            ))
        }

        val newLeagues = leaguesDao.getLeagues(Football).map { it.toLeagues() }
        emit(Resource.Success(newLeagues))

    }

    override fun allLeagues(): Flow<AllFootballLeagues> {
        return leaguesDao.allLeagues(Football)
    }


}