package com.richard.nimble.feature_authentication.presentation.components.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.richard.nimble.R


@Composable
fun SubmitButton(
    btnText : String = stringResource(id = R.string.submit),
    action : Unit,
    modifier: Modifier = Modifier
){
    OutlinedButton(
        onClick = { action },
        modifier = modifier
            .padding(16.dp)
            .height(56.dp)
            .background(
                colorResource(id = R.color.white),
                RoundedCornerShape(12.dp)
            ),
    ) {
        Text(
            text = btnText,
            color = colorResource(id = R.color.grey_black)
        )
    }
}