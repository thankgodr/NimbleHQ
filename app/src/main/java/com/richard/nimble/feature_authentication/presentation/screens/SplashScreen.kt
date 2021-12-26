package com.richard.nimble.feature_authentication.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.richard.nimble.R
import com.richard.nimble.core.presentation.Logo
import com.richard.nimble.feature_authentication.presentation.components.auth.AuthInput
import com.richard.nimble.feature_authentication.presentation.components.auth.Overlay
import com.richard.nimble.feature_authentication.presentation.components.splash.BackgroundImage
import com.richard.nimble.feature_authentication.presentation.components.splash.BottomLine

@Preview
@Composable
fun SplashScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.light_grey),
                        colorResource(id = R.color.think_black)
                    )
                )
            )
    ){
        BackgroundImage()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            BottomLine(
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Logo()
        }
    }
}