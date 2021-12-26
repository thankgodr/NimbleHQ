package com.richard.nimble.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.richard.nimble.R

@Composable
fun Logo(modifier: Modifier = Modifier){
    Image(
        modifier = modifier
            .width(201.dp)
            .height(48.dp),
        painter = painterResource(id = R.drawable.logowhite),
        contentDescription = stringResource(id = R.string.logo),
        contentScale = ContentScale.FillBounds
    )
}