package com.richard.nimble.feature_survey.presentation.Screens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import com.richard.nimble.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.richard.nimble.feature_survey.presentation.SurveyViewModel
import com.richard.nimble.feature_survey.presentation.components.SurveyComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@ExperimentalPagerApi
@Composable
fun SurveyListScreens( viewModel : SurveyViewModel = hiltViewModel() ){
    val surveyState = viewModel.surveyState.value

    Box(
      modifier = Modifier.fillMaxSize()
    ){
        surveyState.data?.let { list ->
            val pagerState  = rememberPagerState(1)

            LaunchedEffect(Unit){
                while (true){
                    yield()
                    delay(20000)
                    pagerState.animateScrollToPage(
                        page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                        animationSpec = tween(600)
                    )
                }
            }
            
            HorizontalPager(
                state = pagerState,
                count = list.size,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                SurveyComponent(survey = list[page])
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = 16.dp,
                        bottom = 150.dp
                    ),
                activeColor = Color.White,
                inactiveColor = colorResource(id = R.color.grey_white)
            )
        }

        if(surveyState.error.isNotBlank()) {
            Text(
                text = surveyState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(surveyState.isLoading) {
           viewModel.refresh(true)
        }


    }
}