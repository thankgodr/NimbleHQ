package com.richard.nimble.feature_survey.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SurveyListResponse(
    @SerializedName("data")
    val `data`: List<SurveyDto>,
    @SerializedName("meta")
    val meta: Meta
)