package com.richard.nimble.feature_authentication.domain.model

data class ClientAuthRequest(
    val email : String,
    val password : String,
    val passwordConfirm : String = "",
    val token : String = "",
    val refreshToken : String = ""
)