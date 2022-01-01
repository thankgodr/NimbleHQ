package com.richard.nimble.feature_authentication.data.repository

import com.richard.nimble.feature_authentication.data.remote.NimpleAuthApi
import com.richard.nimble.feature_authentication.data.remote.dto.*
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.model.CurrentUser
import com.richard.nimble.feature_authentication.domain.repository.Authentication
import java.io.IOException
import javax.inject.Inject

class FakeAuthenticationNegativeImple @Inject constructor(
    private val api : NimpleAuthApi
) : Authentication {
    override suspend fun login(request: ClientAuthRequest): CurrentUser {
       throw IOException("invalid")
    }

    override suspend fun register(request: ClientAuthRequest): CurrentUser {
        throw IOException("invalid")
    }

    override suspend fun logout(request: ClientAuthRequest): String {
        throw IOException("invalid")
    }

    override suspend fun resetPasword(request: ClientAuthRequest): String {
        throw IOException("invalid")
    }

    override suspend fun refresh(request: ClientAuthRequest): CurrentUser {
        throw IOException("invalid")
    }

}