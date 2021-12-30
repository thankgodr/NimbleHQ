package com.richard.nimble.feature_authentication.presentation.screens.auth

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.richard.nimble.R
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.richard.nimble.core.data.Constants
import com.richard.nimble.feature_authentication.presentation.AuthState
import com.richard.nimble.feature_authentication.presentation.AuthViewModel
import com.richard.nimble.feature_authentication.presentation.components.auth.LoadersComponent
import com.richard.nimble.feature_survey.presentation.SurveyListActivty

@Composable
fun LoadingScreen(viewModel : AuthViewModel = hiltViewModel()){
    val authState = viewModel.state
    if(!authState.value.isLoading && authState.value.error.isEmpty()){
        val ctx = LocalContext.current
        ctx.startActivity(Intent(ctx, SurveyListActivty::class.java))
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(id = R.color.grey_black)
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
      ) {
            Column {
                LoadersComponent(width = 127, aminatedelay = 5)
                Spacer(modifier = Modifier.height(10.dp))
                LoadersComponent(width = 110, aminatedelay = 5)
            }
            
            Image(
                painter = painterResource(id = R.drawable.oval) ,
                contentDescription = stringResource(id = R.string.oval))
        }

        Column(
            modifier = Modifier
                .padding(16.dp)) {
            LoadersComponent(width = 50, aminatedelay = 5)
            Spacer(modifier = Modifier.height(10.dp))
            LoadersComponent(width = 253, aminatedelay = 5)
            Spacer(modifier = Modifier.height(10.dp))
            LoadersComponent(width = 120, aminatedelay = 5)
            Spacer(modifier = Modifier.height(10.dp))
            LoadersComponent(width = 300, aminatedelay = 5)
            Spacer(modifier = Modifier.height(10.dp))
            LoadersComponent(width = 210, aminatedelay = 5)
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}