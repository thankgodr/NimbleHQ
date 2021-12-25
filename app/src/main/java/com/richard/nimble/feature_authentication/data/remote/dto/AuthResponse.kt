package com.richard.nimble.feature_authentication.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.richard.nimble.feature_authentication.domain.model.CurrentUser

data class AuthResponse(
    @SerializedName("data")
    val `data`: Data
)

fun AuthResponse.toCurrentUser() : CurrentUser{
    return CurrentUser(
       "",
        data.attributes.accessToken,
        data.attributes.refreshToken
    )
}