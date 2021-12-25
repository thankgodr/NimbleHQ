package com.richard.nimble.feature_authentication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LoginEmailRequest(
    @SerializedName("client_id")
    val clientId: String,
    @SerializedName("client_secret")
    val clientSecret: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("grant_type")
    val grantType: String,
    @SerializedName("password")
    val password: String
)