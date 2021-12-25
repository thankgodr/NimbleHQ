package com.richard.nimble.feature_authentication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String
)