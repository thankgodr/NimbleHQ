package com.richard.nimble.feature_authentication.presentation.components.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import com.richard.nimble.R

@Composable
fun Overlay(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        colorResource(id = R.color.form_gradient1),
                        colorResource(id = R.color.form_gradient2)
                    )
                )
            )
    ) {
            Spacer( modifier = Modifier.fillMaxSize())
    }
}