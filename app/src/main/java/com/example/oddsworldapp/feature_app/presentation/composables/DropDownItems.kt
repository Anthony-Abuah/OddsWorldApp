package com.example.oddsworldapp.feature_app.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oddsworldapp.feature_app.presentation.ui.theme.LeaguesBarTextColor

@Composable
fun DropDownItems(
    league: String,
    onSelect: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onSelect(league)
            }
            .padding(start = 8.dp, end = 8.dp, top = 5.dp, bottom = 5.dp)
    ) {
        BasicText(text = league, fontSize = 15.sp, textColor = LeaguesBarTextColor)
    }

}
