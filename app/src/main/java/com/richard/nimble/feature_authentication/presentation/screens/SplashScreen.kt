package com.richard.nimble.feature_authentication.presentation.screens

import android.content.Intent
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.richard.nimble.R
import com.richard.nimble.core.data.Constants
import com.richard.nimble.core.presentation.Logo
import com.richard.nimble.feature_authentication.presentation.AuthViewModel
import com.richard.nimble.feature_authentication.presentation.components.auth.AuthInput
import com.richard.nimble.feature_authentication.presentation.components.auth.Overlay
import com.richard.nimble.feature_authentication.presentation.components.splash.BackgroundImage
import com.richard.nimble.feature_authentication.presentation.components.splash.BottomLine
import com.richard.nimble.feature_survey.presentation.SurveyListActivty
import kotlinx.coroutines.delay


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SplashScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel()){
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    if(viewModel.userLoggedIn.value){
        val ctx =  LocalContext.current
        ctx.startActivity(Intent(ctx, SurveyListActivty::class.java))
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(4000L)
        viewModel.checkIfUserLoggedIn()

        navController.navigate(Constants.Route.login)
    }
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
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Logo(Modifier.scale(scale.value))

        }
    }
}