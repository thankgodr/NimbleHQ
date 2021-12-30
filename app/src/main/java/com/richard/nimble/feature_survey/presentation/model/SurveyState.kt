package com.richard.nimble.feature_survey.presentation.model

import com.richard.nimble.feature_survey.domain.Survey

data class SurveyState<T>(
   val isLoading : Boolean = false,
   val data : T? = null,
   val error : String = ""
)
