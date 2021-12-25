package com.richard.nimble.feature_authentication.domain.repository

import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.model.CurrentUser

interface Authentication {
    suspend fun login(request : ClientAuthRequest) : CurrentUser
    suspend fun register(request : ClientAuthRequest) : CurrentUser
    suspend fun logout(request : ClientAuthRequest) : String
    suspend fun resetPasword(request : ClientAuthRequest) : String
    suspend fun refresh(request: ClientAuthRequest) : CurrentUser
}