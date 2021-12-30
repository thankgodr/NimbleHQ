package com.richard.nimble.feature_survey.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.richard.nimble.R
import okhttp3.internal.proxy.NullProxySelector.select

@Preview
@Composable
fun     CirculerButton(
    modifier: Modifier = Modifier,
    action : () -> Unit = {}
){
    OutlinedButton(
        onClick =  action,
        shape = CircleShape,
        modifier=  modifier
            .width(58.dp)
            .height(58.dp)
            .background(
                color = Color.White,
                shape = CircleShape)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right) ,
            contentDescription = stringResource(id = R.string.select) )
    }
}