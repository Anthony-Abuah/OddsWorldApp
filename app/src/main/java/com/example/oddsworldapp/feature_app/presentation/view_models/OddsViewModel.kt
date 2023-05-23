package com.example.oddsworldapp.feature_app.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oddsworldapp.core.util.Constants.No_Value
import com.example.oddsworldapp.core.util.Constants.host
import com.example.oddsworldapp.core.util.Constants.key
import com.example.oddsworldapp.core.util.Resource
import com.example.oddsworldapp.core.util.UIEvent
import com.example.oddsworldapp.feature_app.data.local.entities.odds_entity.OddsEntity
import com.example.oddsworldapp.feature_app.domain.model.odds.Bookmaker
import com.example.oddsworldapp.feature_app.domain.repository.OddsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OddsViewModel @Inject constructor(
    private val oddsRepository: OddsRepository
): ViewModel() {

    private val _oddsState = mutableStateOf(OddsState())
    val oddsState: State<OddsState> = _oddsState

    var odd by mutableStateOf(OddsEntity(null, No_Value, emptyList<Bookmaker>() , No_Value, No_Value, No_Value, No_Value, No_Value))
    private set

    var selectedBookmaker = mutableStateOf(No_Value)
    private set

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    val allOdds = oddsRepository.getRoomOdds()

    fun getOdds(league: String, sport: String, regions: String) = viewModelScope.launch {
        oddsRepository.getOdds(key, host, league, sport, regions).onEach { response->
            when(response){
                is Resource.Success ->{
                    _oddsState.value = oddsState.value.copy(
                        odds = response.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading ->{
                    _oddsState.value = oddsState.value.copy(
                        odds = response.data ?: emptyList(),
                        isLoading = true
                    )
                }
                is Resource.Error ->{
                    _oddsState.value = oddsState.value.copy(
                        odds = response.data ?: emptyList(),
                        isLoading = false
                    )
                    _eventFlow.emit(UIEvent.ShowSnackBar(
                        response.message ?: "Unknown Error"
                    ))
                }
            }
        }.launchIn(this)

    }

    fun onSelectBookmaker(bookmaker: String){
        selectedBookmaker.value = bookmaker
    }


}