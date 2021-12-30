package com.richard.nimble.feature_authentication.data.repository

import com.richard.nimble.core.data.Constants
import com.richard.nimble.feature_authentication.data.remote.NimpleAuthApi
import com.richard.nimble.feature_authentication.data.remote.dto.*
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.model.CurrentUser
import com.richard.nimble.feature_authentication.domain.repository.Authentication
import javax.inject.Inject

class AuthenticationImpl @Inject constructor(
    private val api: NimpleAuthApi
) : Authentication {
    override suspend fun login(request: ClientAuthRequest): CurrentUser {
        val loginrequest = LoginEmailRequest(
            Constants.apiKey,
            Constants.apiSecret,
            request.email,
            Constants.grantType.password,
            request.password
        )
      return  api.loginWithEmail(loginrequest).toCurrentUser()
    }

    override suspend fun register(request: ClientAuthRequest): CurrentUser {
        val regRequest = RegistrationRequest(
            Constants.apiKey,
            Constants.apiSecret,
            User(request.email,
                request.password,
                request.passwordConfirm)
        )
       return api.register(regRequest).toCurrentUser()
    }

    override suspend fun logout(request: ClientAuthRequest): String {
        val logoutRequest = LogoutRequest(
            Constants.apiKey,
            Constants.apiSecret,
            request.token
        )
        return api.logout(logoutRequest).meta.message
    }

    override suspend fun resetPasword(request: ClientAuthRequest): String {
      val resetRequest = ForgotPasswordRequest(
          Constants.apiKey,
          Constants.apiSecret,
          UserX(
              request.email
          )
      )
        return api.resetPassword(resetRequest).meta.message
    }

    override suspend fun refresh(request: ClientAuthRequest): CurrentUser {
        val refreshRequest = RefreshTokenRequest(
            Constants.apiKey,
            Constants.apiSecret,
            Constants.grantType.refresh,
            request.refreshToken
        )
       return api.refreshToken(refreshRequest).toCurrentUser()
    }

}