package com.richard.nimble.feature_authentication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("created_at")
    val createdAt: Int = 0,
    @SerializedName("expires_in")
    val expiresIn: Int = 0,
    @SerializedName("refresh_token")
    val refreshToken: String = "",
    @SerializedName("token_type")
    val tokenType: String = ""
)