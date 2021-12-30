package com.richard.nimble.feature_authentication.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.richard.nimble.R
import com.richard.nimble.core.data.Constants
import com.richard.nimble.core.presentation.Logo
import com.richard.nimble.feature_authentication.presentation.AuthViewModel
import com.richard.nimble.feature_authentication.presentation.components.auth.AuthInput
import com.richard.nimble.feature_authentication.presentation.components.auth.SubmitButton
import com.richard.nimble.feature_authentication.presentation.components.splash.BottomLine

@Composable
fun LoginScreen(navController: NavController ,viewModel : AuthViewModel = hiltViewModel()){
    val authState = viewModel.state
    if(authState.value.isLoading){
        navController.navigate(Constants.Route.loading)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.overlay),
            contentDescription = stringResource(id =  R.string.overlay),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Logo()
                Spacer(modifier = Modifier.height(120.dp))
                AuthInput(
                    placeHolder = stringResource(id = R.string.email),
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { email ->
                        viewModel.setEmail(email = email)
                    },
                    iserror = viewModel.invalideEmail.value,
                    values = viewModel.emailInput
                )
                AuthInput(
                    placeHolder = stringResource(id = R.string.password),
                    modifier = Modifier.fillMaxWidth(),
                    transformation = PasswordVisualTransformation(),
                    values = viewModel.passwordInput,
                    iserror = viewModel.invalidPassword.value,
                    onValueChange = { password ->
                        viewModel.setPassword(password = password)
                    }
                )
                SubmitButton(
                    action = {viewModel.validate()},
                    btnText = stringResource(id = R.string.login),
                    modifier = Modifier.fillMaxWidth()
                )
            }


            BottomLine(
                modifier =
                Modifier.padding(bottom = 16.dp)
            )
        }
    }
}
