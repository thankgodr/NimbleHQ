package com.richard.nimble.feature_authentication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LogoutRequest(
    @SerializedName("client_id")
    val clientId: String,
    @SerializedName("client_secret")
    val clientSecret: String,
    @SerializedName("token")
    val token: String
)