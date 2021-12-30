package com.richard.nimble.feature_survey.domain


interface SurveysSignature {
    suspend fun getSurveys() : List<Survey>
    suspend fun getSurveyDetails(id : String) : Survey
}