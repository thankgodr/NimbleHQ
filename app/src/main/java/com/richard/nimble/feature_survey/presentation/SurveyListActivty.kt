package com.richard.nimble.feature_survey.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.richard.nimble.feature_authentication.presentation.components.NavigationHost
import com.richard.nimble.feature_survey.presentation.Screens.RefreshListScreen
import com.richard.nimble.feature_survey.presentation.Screens.SurveyListScreens
import com.richard.nimble.ui.theme.NimbleTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SurveyListActivty : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NimbleTheme {
                // A surface container using the 'background' color from the theme
                    Scaffold {
                        RefreshListScreen()
                    }
            }
        }
    }
}