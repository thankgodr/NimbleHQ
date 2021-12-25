package com.richard.nimble.feature_authentication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("message")
    val message: String
)