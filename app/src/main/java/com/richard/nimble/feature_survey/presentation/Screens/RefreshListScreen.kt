package com.richard.nimble.feature_survey.presentation.Screens

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.richard.nimble.feature_survey.presentation.SurveyViewModel

@ExperimentalPagerApi
@Composable
fun RefreshListScreen(viewModel: SurveyViewModel = hiltViewModel()){
    val isRefreshing by viewModel.isRefreshing
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing)
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            viewModel.refresh()
        },
    ){
        SurveyListScreens()
    }
}