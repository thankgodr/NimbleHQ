package com.richard.nimble.feature_survey.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.richard.nimble.feature_survey.domain.Survey

data class SurveyDetailsResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("included")
    val included: List<Included>
)

fun SurveyDetailsResponse.toSurvey() : Survey{
    return Survey(
        data.attributes.title,
        data.attributes.description,
        data.attributes.coverImageUrl,
        ""
    )
}