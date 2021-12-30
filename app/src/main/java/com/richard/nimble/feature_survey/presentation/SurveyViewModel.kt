package com.richard.nimble.feature_survey.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.richard.nimble.R
import com.richard.nimble.core.data.Resource
import com.richard.nimble.feature_survey.domain.GetSurveListUseCase
import com.richard.nimble.feature_survey.domain.GetSurveyDeatailsUseCase
import com.richard.nimble.feature_survey.domain.Survey
import com.richard.nimble.feature_survey.presentation.model.SurveyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SurveyViewModel @Inject constructor(
    private val getSurveListUseCase: GetSurveListUseCase,
    private val getSurveyDeatailsUseCase: GetSurveyDeatailsUseCase
) : ViewModel() {

    private val _surveyState = mutableStateOf(SurveyState<List<Survey>>())
    val surveyState : State<SurveyState<List<Survey>>> = _surveyState

    //RefreshState
    private val _isRefreshing = mutableStateOf(false)
    val isRefreshing : State<Boolean> = _isRefreshing

    init {
        getSurveyList()
    }

    fun refresh(){
        _isRefreshing.value = true
        getSurveyList()
    }

    fun refresh(status: Boolean){
        _isRefreshing.value = status
    }

    private fun getSurveyList(){
        getSurveListUseCase().onEach { result ->
            when(result){
                is Resource.Loading -> {
                   _surveyState.value = SurveyState(isLoading = true)
                }
                is Resource.Error -> {
                    _surveyState.value = SurveyState(
                        error = result.message ?: "Unexpected Error"
                        )
                }
                is Resource.Success -> {
                    _isRefreshing.value = false
                    _surveyState.value = SurveyState(data = result.data)

                }
            }
        }.launchIn(viewModelScope)
    }
}