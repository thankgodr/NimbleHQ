package com.richard.nimble.feature_survey.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String
)