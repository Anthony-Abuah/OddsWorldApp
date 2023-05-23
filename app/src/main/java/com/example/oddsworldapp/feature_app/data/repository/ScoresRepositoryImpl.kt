package com.example.oddsworldapp.feature_app.data.repository

import com.example.oddsworldapp.core.util.Resource
import com.example.oddsworldapp.feature_app.data.local.entities.scores_entity.ScoresDao
import com.example.oddsworldapp.feature_app.data.remote.OddsWorldApi
import com.example.oddsworldapp.feature_app.domain.model.scores.Scores
import com.example.oddsworldapp.feature_app.domain.repository.ScoresRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ScoresRepositoryImpl(
    private val scoresWorldApi: OddsWorldApi,
    private val scoresDao: ScoresDao
): ScoresRepository {
    override fun getScores(key: String, host: String, league: String, sport: String): Flow<Resource<List<Scores>>> = flow{
        emit(Resource.Loading())

        val scores = scoresDao.getScores().map{it.toScores()}
        emit(Resource.Loading(data = scores))

        try {
            val remoteScores = scoresWorldApi.getScores(key, host, league, sport)
            scoresDao.deleteScores()
            scoresDao.insertScores(remoteScores.map { it.toScoresEntity() })
        }catch (e: HttpException){
            emit(Resource.Error(
                message = "Something went wrong",
                data = scores
            ))
        }catch (e: IOException){
            emit(Resource.Error(
                message = "Couldn't connect to the server",
                data = scores
            ))
        }

        val newScores = scoresDao.getScores().map { it.toScores() }
        emit(Resource.Success(newScores))

    }
}