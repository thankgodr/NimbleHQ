package com.richard.nimble.feature_survey.data.repository

import com.richard.nimble.feature_survey.data.remote.SurveyApi
import com.richard.nimble.feature_survey.domain.Survey
import com.richard.nimble.feature_survey.domain.SurveysSignature
import java.io.IOException
import javax.inject.Inject

class FakeSurveyNegativeImpl @Inject constructor(
    private val api : SurveyApi
) : SurveysSignature {
    override suspend fun getSurveys(): List<Survey> {
        throw IOException()
    }

    override suspend fun getSurveyDetails(id: String): Survey {
        throw IOException()
    }
}