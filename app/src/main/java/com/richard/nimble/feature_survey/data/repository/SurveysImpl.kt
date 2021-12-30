package com.richard.nimble.feature_survey.data.repository

import com.richard.nimble.feature_survey.data.remote.SurveyApi
import com.richard.nimble.feature_survey.data.remote.dto.toSurvey
import com.richard.nimble.feature_survey.domain.Survey
import com.richard.nimble.feature_survey.domain.SurveysSignature
import javax.inject.Inject

class SurveysImpl @Inject constructor(
    private val api : SurveyApi
) : SurveysSignature {
    override suspend fun getSurveys(): List<Survey> {
      return api.getSurveys().data.map {
           it.toSurvey()
       }
    }

    override suspend fun getSurveyDetails(id: String): Survey {
      return api.getSurveyDetails(id).toSurvey()
    }
}