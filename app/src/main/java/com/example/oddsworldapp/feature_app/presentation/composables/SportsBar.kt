package com.example.oddsworldapp.feature_app.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oddsworldapp.R
import com.example.oddsworldapp.feature_app.presentation.ui.theme.SportsBarBackgroundColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.SportsBarTextColor

@Composable
fun SportsBar(
    title: String,
    dropDown: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.height(65.dp)
            .background(SportsBarBackgroundColor)
            .padding(
                start = 4.dp,
                end = 4.dp
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f)
                .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(painter = painterResource(id = R.drawable.football), contentDescription = "football icon")
        }

        Row(modifier = Modifier
            .weight(5f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            TitleText(title = title, fontSize = 24.sp, SportsBarTextColor)
        }

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            ForwardArrowCard(dropDown)
        }

    }
}