package com.richard.nimble.feature_authentication.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.richard.nimble.R
import com.richard.nimble.core.Constants.grantType.password
import com.richard.nimble.core.presentation.Logo
import com.richard.nimble.feature_authentication.presentation.components.auth.AuthInput
import com.richard.nimble.feature_authentication.presentation.components.auth.SubmitButton

@Preview
@Composable
fun LoginScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.overlay),
            contentDescription = stringResource(id =  R.string.overlay) )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 160.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo()
            Spacer(modifier = Modifier.height(150.dp))
            AuthInput(placeHolder = stringResource(id = R.string.email), modifier = Modifier.fillMaxWidth())
            AuthInput(placeHolder = stringResource(id = R.string.password),modifier = Modifier.fillMaxWidth(), transformation = PasswordVisualTransformation())
            SubmitButton(
                action = print("hello"),
                btnText = stringResource(id = R.string.login),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
