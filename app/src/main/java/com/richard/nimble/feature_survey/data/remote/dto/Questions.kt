package com.richard.nimble.feature_survey.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Questions(
    @SerializedName("data")
    val `data`: List<DataX>
)