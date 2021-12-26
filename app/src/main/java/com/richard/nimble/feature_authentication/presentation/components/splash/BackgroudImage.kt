package com.richard.nimble.feature_authentication.presentation.components.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.richard.nimble.R

@Composable
fun BackgroundImage(modifier: Modifier = Modifier){
    Image(
        modifier = modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.background ),
        contentDescription = stringResource(id = R.string.background_image)
    )
}