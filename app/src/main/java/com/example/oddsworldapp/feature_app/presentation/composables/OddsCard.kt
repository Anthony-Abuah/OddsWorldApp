package com.example.oddsworldapp.feature_app.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.oddsworldapp.feature_app.presentation.ui.theme.OddsCardBackgroundColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.OddsCardContentColor

@Composable
fun OddsCard(
    homeTeam: String,
    homeOdds: String,
    awayTeam: String,
    awayOdds: String,
    time: String,
    date: String,
    drawOdds: String
){
    Card(
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            contentColor = OddsCardContentColor,
            containerColor = OddsCardBackgroundColor,
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.weight(1f)){
                HomeTeam(homeTeam, homeOdds)
            }
            Box(modifier = Modifier.weight(1f)){
                Draw(market = "1x2", time = time, date = date, drawOdds)
            }
            Box(modifier = Modifier.weight(1f)){
                AwayTeam(awayTeam, awayOdds)
            }
        }
    }
}