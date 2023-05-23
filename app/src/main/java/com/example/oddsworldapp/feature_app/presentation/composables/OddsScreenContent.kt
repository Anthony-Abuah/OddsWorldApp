package com.example.oddsworldapp.feature_app.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.oddsworldapp.core.util.Constants.Bookmakers
import com.example.oddsworldapp.core.util.Constants.No_Value
import com.example.oddsworldapp.feature_app.data.local.entities.leagues_entity.LeaguesEntity
import com.example.oddsworldapp.feature_app.data.local.entities.odds_entity.OddsEntity
import com.example.oddsworldapp.feature_app.presentation.ui.theme.MainBackgroundColor
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun OddsScreenContent(
    leagues: List<LeaguesEntity>,
    odds: List<OddsEntity>,
    selectedBookmaker: String,
    state: Boolean,
    onSelectBookmaker: (bookmaker: String) -> Unit,
    getLeagues: (leagues: String) -> Unit
) {

    val shortFormat = "dd-MM-yyyy"
    val shortDateFormat = SimpleDateFormat(shortFormat, Locale.UK)

    val timeFormat = "HH:mm"
    val shortTimeFormat = SimpleDateFormat(timeFormat, Locale.UK)

    val longFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    val longDateFormat = SimpleDateFormat(longFormat, Locale.UK)



    val leagueNames = mutableListOf<String>()
    for(league in leagues){
        leagueNames.add(league.title)
    }


    var selectedLeague by remember {
        mutableStateOf("EPL")
    }


    var sportsKey by remember {
        mutableStateOf(No_Value)
    }


    var expanded by remember {
        mutableStateOf(false)
    }

    var launch by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MainBackgroundColor)) {


        Box(modifier = Modifier.weight(1f)){
            SportsBar(title = "Football" ) {}
        }

        Box(modifier = Modifier.weight(0.8f)){
            LeagueBar(title = selectedLeague) { expanded = !expanded }
        }

        AnimatedVisibility(visible = expanded) {
            Card(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .requiredHeight(150.dp),
                elevation = 15.dp,
                backgroundColor = Color.White,
                shape = RoundedCornerShape(5.dp)
            ) {

                LazyColumn(
                    modifier = Modifier.heightIn(max = 150.dp),
                ) {
                    items(leagueNames) {
                        DropDownItems(league = it) { _league ->
                            selectedLeague = _league

                            val leagueIndices = leagues.indices
                            for(index in leagueIndices){
                                if (leagues[index].title == selectedLeague){
                                    sportsKey = leagues[index].key
                                    launch = true
                                }
                            }

                            expanded = false

                        }
                    }

                }

            }
        }

        if (launch) {
            LaunchedEffect(Unit) {
                getLeagues(sportsKey)
                launch = false
            }
        }


        ScrollableRow(Bookmakers, selectedBookmaker){_selectedBookmaker->
            onSelectBookmaker(_selectedBookmaker)
        }


            if (state){
                Box(modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(9f)
                    .padding(4.dp)
            ) {
                items(
                    items = odds
                ) { currentOdds ->
                    var currentBookmaker = currentOdds.bookmakers[0]
                    val bookmakerIndices = currentOdds.bookmakers.indices

                    for(index in bookmakerIndices){
                        if (currentOdds.bookmakers[index].title == selectedBookmaker){
                            currentBookmaker = currentOdds.bookmakers[index]
                        }
                    }

                    val isoDate = longDateFormat.parse((currentOdds.commence_time)) !!
                    OddsCard(
                        homeTeam = currentOdds.home_team,
                        homeOdds = currentBookmaker.markets[0].outcomes[0].price.toString(),
                        awayTeam = currentOdds.away_team,
                        awayOdds = currentBookmaker.markets[0].outcomes[1].price.toString(),
                        time = shortTimeFormat.format(isoDate),
                        date = shortDateFormat.format(isoDate),
                        drawOdds = currentBookmaker.markets[0].outcomes[2].price.toString()
                    )

                }

            //}

        }

    }
}