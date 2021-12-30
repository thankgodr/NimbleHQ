package com.richard.nimble.feature_survey.data.remote

import com.richard.nimble.feature_authentication.domain.use_case.SessionManager
import com.richard.nimble.feature_survey.data.remote.dto.SurveyDetailsResponse
import com.richard.nimble.feature_survey.data.remote.dto.SurveyListResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import javax.inject.Inject

interface SurveyApi  {

    @GET("/api/v1/surveys")
    suspend fun getSurveys() : SurveyListResponse

    @GET("}/api/v1/surveys/{id}")
    suspend fun getSurveyDetails(@Path("id") id : String) : SurveyDetailsResponse

}