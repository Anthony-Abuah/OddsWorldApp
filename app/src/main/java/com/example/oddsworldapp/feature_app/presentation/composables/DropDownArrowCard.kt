package com.example.oddsworldapp.feature_app.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.oddsworldapp.R
import com.example.oddsworldapp.feature_app.presentation.ui.theme.DropDownArrowCardBackgroundColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.DropDownArrowCardContentColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.ForwardArrowCardBackgroundColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.ForwardArrowCardContentColor

@Composable
fun ForwardArrowCard(
    dropDown: () -> Unit,
){
    Card(
        shape = androidx.compose.foundation.shape.CircleShape,
        colors = CardDefaults.cardColors(
            contentColor = ForwardArrowCardContentColor,
            containerColor = ForwardArrowCardBackgroundColor,
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        IconButton(
            modifier = Modifier.fillMaxSize(),
            onClick = dropDown
        ) {
            Image(painter = painterResource(id = R.drawable.arrow_forward), contentDescription = "")
        }



    }
}

@Composable
fun DropDownArrowCard(
    dropDown: () -> Unit,
){
    Card(
        shape = androidx.compose.foundation.shape.CircleShape,
        colors = CardDefaults.cardColors(
            contentColor = DropDownArrowCardContentColor,
            containerColor = DropDownArrowCardBackgroundColor,
        ),
        modifier = Modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        IconButton(
            modifier = Modifier,
            onClick = dropDown
        ) {
            Image(painter = painterResource(id = R.drawable.drop_down_arrow), contentDescription = "")
        }



    }
}

