package com.richard.nimble.feature_authentication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ForgotPasswordResponse(
    @SerializedName("meta")
    val meta: Meta
)