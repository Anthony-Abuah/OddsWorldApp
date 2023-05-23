package com.example.oddsworldapp.feature_app.presentation.composables

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.focusable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oddsworldapp.feature_app.domain.model.odds.Bookmaker
import com.example.oddsworldapp.feature_app.presentation.ui.theme.BookMakerCardBackgroundColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.BookMakerCardContentColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.SelectedBookMakerCardBackgroundColor

@Composable
fun ScrollableRow(
    bookmakers: List<String>,
    selectedBookmaker: String,
    bookmakerSelected: (bookmaker: String) -> Unit
){
    var isSelected by remember {
        mutableStateOf(false)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val scrollState = rememberScrollState (0)


    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp)
        .horizontalScroll(state = scrollState, enabled = true)) {
        for (bookmaker in bookmakers){
            Card(
                shape = MaterialTheme.shapes.small,
                colors = CardDefaults.cardColors(
                    contentColor = BookMakerCardContentColor,
                    containerColor = if((bookmaker == selectedBookmaker)) SelectedBookMakerCardBackgroundColor else BookMakerCardBackgroundColor),
                modifier = Modifier
                    .height(40.dp)
                    .padding(4.dp)
                    .focusable(enabled = true, interactionSource = interactionSource),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ){
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
                    .toggleable(value = isSelected,
                        onValueChange = {
                            bookmakerSelected(bookmaker)
                            //if(bookmaker == selectedBookmaker){}
                            isSelected = !isSelected
                        }),
                    contentAlignment = Alignment.Center
                ){
                    BasicText(text = bookmaker, fontSize = 16.sp, textColor = BookMakerCardContentColor)
                }
            }
        }
        
    }
    
}