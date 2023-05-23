package com.example.oddsworldapp.feature_app.presentation.composables
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.oddsworldapp.feature_app.presentation.ui.theme.TopBarBackgroundColor
import com.example.oddsworldapp.feature_app.presentation.ui.theme.TopBarTextColor

@Composable
fun AppTopBar(
    label: String,
) {
    TopAppBar (
        title = {
            TitleText(title = label, 18.sp, TopBarTextColor)
        },
        backgroundColor = TopBarBackgroundColor,

    )
}
