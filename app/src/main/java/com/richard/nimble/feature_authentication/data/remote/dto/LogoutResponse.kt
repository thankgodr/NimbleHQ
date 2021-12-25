package com.richard.nimble.feature_authentication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LogoutResponse(
    @SerializedName("meta")
    val meta: MetaX
)