package com.example.oddsworldapp.feature_app.presentation.composables


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun BasicText(
    text: String,
    fontSize: TextUnit,
    textColor: Color
) {
    Text(
        text = text,
        fontWeight= FontWeight.Normal,
        color = textColor,
        fontSize = fontSize,
        textAlign = TextAlign.Center
    )
}
