package com.richard.nimble.feature_survey.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Answers(
    @SerializedName("data")
    val `data`: List<DataXXX>
)