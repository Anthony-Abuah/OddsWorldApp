package com.example.oddsworldapp.feature_app.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oddsworldapp.core.util.Constants.host
import com.example.oddsworldapp.core.util.Constants.key
import com.example.oddsworldapp.core.util.Resource
import com.example.oddsworldapp.core.util.UIEvent
import com.example.oddsworldapp.feature_app.domain.repository.LeaguesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LeaguesViewModel @Inject constructor(
    private val leaguesRepository: LeaguesRepository
): ViewModel() {

    private val _leaguesState = mutableStateOf(LeaguesState())
    val leaguesState: State<LeaguesState> = _leaguesState


    val allLeagues  = leaguesRepository.allLeagues()


    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun getLeagues(leagueKey: String) = viewModelScope.launch {
        leaguesRepository.getLeagues(key, host, leagueKey).onEach { response->
            when(response){
                is Resource.Success ->{
                    _leaguesState.value = leaguesState.value.copy(
                        leagues = response.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading ->{
                    _leaguesState.value = leaguesState.value.copy(
                        leagues = response.data ?: emptyList(),
                        isLoading = true
                    )
                }
                is Resource.Error ->{
                    _leaguesState.value = leaguesState.value.copy(
                        leagues = response.data ?: emptyList(),
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