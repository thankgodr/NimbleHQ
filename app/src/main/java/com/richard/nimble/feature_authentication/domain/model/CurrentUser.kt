package com.richard.nimble.feature_authentication.domain.model

data class CurrentUser(
    val email : String,
    val acessToken : String,
    val refreshToken : String
)
