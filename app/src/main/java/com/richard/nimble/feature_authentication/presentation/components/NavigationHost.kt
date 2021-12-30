package com.richard.nimble.feature_authentication.presentation.components

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.richard.nimble.core.data.Constants
import com.richard.nimble.feature_authentication.presentation.AuthState
import com.richard.nimble.feature_authentication.presentation.AuthViewModel
import com.richard.nimble.feature_authentication.presentation.screens.SplashScreen
import com.richard.nimble.feature_authentication.presentation.screens.auth.LoadingScreen
import com.richard.nimble.feature_authentication.presentation.screens.auth.LoginScreen
import com.richard.nimble.feature_authentication.presentation.screens.auth.ResetPasswordScreen
import com.richard.nimble.feature_survey.presentation.SurveyListActivty

@Composable
fun NavigationHost(navController: NavHostController, authViewModel: AuthViewModel = hiltViewModel()){
   NavHost(
       navController = navController,
       startDestination = Constants.Route.splash
   ){
       composable(
           Constants.Route.login,
       ){
           LoginScreen(navController)
       }
       composable(
           Constants.Route.resetPassword
       ){
           ResetPasswordScreen()
       }
       composable(
           Constants.Route.splash
       ){
           SplashScreen(navController)
       }
       composable(
           Constants.Route.loading
       ){
           LoadingScreen()
       }
   }
}