package com.richard.nimble.feature_survey.data.remote.dto


import com.google.gson.annotations.SerializedName

data class RelationshipsX(
    @SerializedName("questions")
    val questions: QuestionsX
)