package com.example.oddsworldapp.feature_app.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.oddsworldapp.feature_app.presentation.ui.theme.DropDownArrowCardBackgroundColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.LeaguesBarBackgroundColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.LeaguesBarTextColor

@Composable
fun LeagueBar(
    title: String,
    expand: () -> Unit
){


    var leagueNameSize by remember {
        mutableStateOf(Size.Zero)
    }

    var expanded by remember {
        mutableStateOf(false)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.height(75.dp)
            .background(LeaguesBarBackgroundColor)
            .padding(start = 16.dp, end = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.background(LeaguesBarBackgroundColor)) {
            Row(modifier = Modifier.background(LeaguesBarBackgroundColor)
                .onGloballyPositioned { coordinates ->
                    leagueNameSize = coordinates.size.toSize()
                },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                TitleText(title = title, fontSize = 15.sp, LeaguesBarTextColor)
            }
        }

        Row(modifier = Modifier.padding(start= 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            DropDownArrowCard(){
                expand()
            }
        }

    }
}