package com.example.oddsworldapp.feature_app.presentation.composables

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.oddsworldapp.core.util.Constants.UK
import com.example.oddsworldapp.core.util.UIEvent
import com.example.oddsworldapp.feature_app.presentation.view_models.LeaguesViewModel
import com.example.oddsworldapp.feature_app.presentation.view_models.OddsViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun OddsScreen(
    leaguesViewModel: LeaguesViewModel = hiltViewModel(),
    oddsViewModel: OddsViewModel = hiltViewModel(),
    ){


    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true){
        oddsViewModel.eventFlow.collectLatest {event->
            when(event){
                is UIEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    LaunchedEffect(key1 = true){
        leaguesViewModel.eventFlow.collectLatest {event->
            when(event){
                is UIEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    LaunchedEffect(Unit){
        leaguesViewModel.getLeagues("soccer_epl")
        oddsViewModel.getOdds("soccer_epl", "soccer_epl", UK)
    }

    val odds by oddsViewModel.allOdds.collectAsState(
        initial = emptyList()
    )

    val allLeagues by leaguesViewModel.allLeagues.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        content = { it
            OddsScreenContent(
                leagues =  allLeagues,
                odds = odds,
                selectedBookmaker = oddsViewModel.selectedBookmaker.value,
                state = oddsViewModel.oddsState.value.isLoading,
                getLeagues = {leagueKey ->
                    leaguesViewModel.getLeagues(leagueKey)
                    oddsViewModel.getOdds(leagueKey, leagueKey, UK)
                },
                onSelectBookmaker = {selectedBookmaker->
                    oddsViewModel.onSelectBookmaker(selectedBookmaker)
                }
                /*getOdds = {league, sport, region ->
                    LaunchedEffect(Unit) {
                        //leaguesViewModel.getLeagues()
                        oddsViewModel.getOdds(league, sport, region)
                    }
                }*/
            )
        }
    )
}