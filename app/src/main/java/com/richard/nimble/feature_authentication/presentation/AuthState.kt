package com.richard.nimble.feature_authentication.presentation

import com.richard.nimble.feature_authentication.domain.model.CurrentUser

data class AuthState (
    val isLoading : Boolean = false,
    val userDetails : CurrentUser? = null,
    val error : String = "",
    val proceed : Boolean = false
)