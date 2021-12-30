package com.richard.nimble.feature_survey.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.richard.nimble.feature_survey.domain.Survey

data class SurveyDto(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String,
    @SerializedName("relationships")
    val relationships: Relationships,
    @SerializedName("type")
    val type: String
)

fun SurveyDto.toSurvey(): Survey{
    return Survey(
        attributes.title,
        attributes.description,
        attributes.coverImageUrl,
        id
    )
}