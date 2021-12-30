package com.richard.nimble.feature_authentication.presentation.components.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.richard.nimble.R

@Composable
fun LoadersComponent(
    width : Int,
    aminatedelay : Int
){
    Divider(
        modifier = Modifier
            .width(width.dp)
            .height(24.dp)
            .background(
            brush = Brush.horizontalGradient(
                listOf(
                    colorResource(id = R.color.loader1),
                    colorResource(id = R.color.grey_white),
                    colorResource(id = R.color.loader3)
                )
            ),
            shape = RoundedCornerShape(14.dp)

        ),

    )
}