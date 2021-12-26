package com.richard.nimble.feature_authentication.presentation.components.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomLine(modifier: Modifier = Modifier){
    Divider(
        modifier = modifier
            .width(136.dp)
            .height(5.dp)
            .background(
                Color.White,
                RoundedCornerShape(10.dp)
            ),

    )
}