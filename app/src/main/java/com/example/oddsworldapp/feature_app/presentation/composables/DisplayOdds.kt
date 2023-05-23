package com.example.oddsworldapp.feature_app.presentation.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oddsworldapp.feature_app.presentation.ui.theme.DisplayOddsCardBackgroundColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.DisplayOddsCardContentColor

@Composable
fun DisplayOdds(
    homeOdds: String,
    drawOdds: String,
    awayOdds: String
){
    
    Row(modifier = Modifier.fillMaxWidth()) {
        
        Card(
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(
                contentColor = DisplayOddsCardContentColor,
                containerColor = DisplayOddsCardBackgroundColor,
            ),
            modifier = Modifier
                .weight(1f)
                .padding(1.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )) {
            TitleText(title = homeOdds, fontSize = 15.sp, textColor = DisplayOddsCardContentColor)
        }
        
        Card(
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(
                contentColor = DisplayOddsCardContentColor,
                containerColor = DisplayOddsCardBackgroundColor,
            ),
            modifier = Modifier
                .weight(1f)
                .padding(1.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )) {
            TitleText(title = drawOdds, fontSize = 15.sp, textColor = DisplayOddsCardContentColor)
        }
        
        Card(
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(
                contentColor = DisplayOddsCardContentColor,
                containerColor = DisplayOddsCardBackgroundColor,
            ),
            modifier = Modifier
                .weight(1f)
                .padding(1.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )) {
            TitleText(title = awayOdds, fontSize = 15.sp, textColor = DisplayOddsCardContentColor)
        }        
    }
    
}