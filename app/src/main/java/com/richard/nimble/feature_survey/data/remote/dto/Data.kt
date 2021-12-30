package com.richard.nimble.feature_survey.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("attributes")
    val attributes: AttributesX,
    @SerializedName("id")
    val id: String,
    @SerializedName("relationships")
    val relationships: RelationshipsX,
    @SerializedName("type")
    val type: String
)
