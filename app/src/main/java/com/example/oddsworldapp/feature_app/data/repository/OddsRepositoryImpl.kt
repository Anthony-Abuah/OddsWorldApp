package com.example.oddsworldapp.feature_app.data.repository

import com.example.oddsworldapp.core.util.Resource
import com.example.oddsworldapp.feature_app.data.local.entities.odds_entity.OddsDao
import com.example.oddsworldapp.feature_app.data.local.entities.odds_entity.OddsEntity
import com.example.oddsworldapp.feature_app.data.remote.OddsWorldApi
import com.example.oddsworldapp.feature_app.domain.model.odds.Odds
import com.example.oddsworldapp.feature_app.domain.repository.OddsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class OddsRepositoryImpl(
    private val oddsWorldApi: OddsWorldApi,
    private val oddsDao: OddsDao
): OddsRepository {
    override fun getOdds(key: String, host: String, league: String, sport: String, regions: String): Flow<Resource<List<Odds>>> = flow{
        emit(Resource.Loading())

        val odds = oddsDao.getOdds().map{it.toOdds()}
        emit(Resource.Loading(data = odds))

        try {
            val remoteOdds = oddsWorldApi.getOdds(key, host, league, sport, regions)
            oddsDao.deleteOdds()
            oddsDao.insertOdds(remoteOdds.map { it.toOddsEntity() })
        }catch (e: HttpException){
            emit(Resource.Error(
                message = "Something went wrong",
                data = odds
            ))
        }catch (e: IOException){
            emit(Resource.Error(
                message = "Couldn't connect to the server",
                data = odds
            ))
        }

        val newOdds = oddsDao.getOdds().map { it.toOdds() }
        emit(Resource.Success(newOdds))

    }

    override fun getRoomOdds(): Flow<List<OddsEntity>> {
        return oddsDao.getRoomOdds()
    }
}