package com.example.oddsworldapp.feature_app.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oddsworldapp.core.util.Constants.host
import com.example.oddsworldapp.core.util.Constants.key
import com.example.oddsworldapp.core.util.Resource
import com.example.oddsworldapp.core.util.UIEvent
import com.example.oddsworldapp.feature_app.domain.repository.ScoresRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ScoresViewModel @Inject constructor(
    private val scoresRepository: ScoresRepository
): ViewModel() {

    private val _scoresState = mutableStateOf(ScoresState())
    val scoresState: State<ScoresState> = _scoresState


    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun getScores(league: String, sport: String) = viewModelScope.launch {
        scoresRepository.getScores(key, host, league, sport).onEach { response->
            when(response){
                is Resource.Success ->{
                    _scoresState.value = scoresState.value.copy(
                        scores = response.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading ->{
                    _scoresState.value = scoresState.value.copy(
                        scores = response.data ?: emptyList(),
                        isLoading = true
                    )
                }
                is Resource.Error ->{
                    _scoresState.value = scoresState.value.copy(
                        scores = response.data ?: emptyList(),
                        isLoading = false
                    )
                    _eventFlow.emit(UIEvent.ShowSnackBar(
                        response.message ?: "Unknown Error"
                    ))
                }
            }
        }.launchIn(this)

    }

}