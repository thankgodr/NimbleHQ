package com.richard.nimble.feature_authentication.data.remote

import com.richard.nimble.feature_authentication.data.remote.dto.*
import retrofit2.http.Body
import retrofit2.http.POST

interface NimpleAuthApi {
    @POST("/api/v1/registrations/")
    suspend fun register(@Body request: RegistrationRequest) : AuthResponse

    @POST("/api/v1/oauth/token")
    suspend fun loginWithEmail(@Body request: LoginEmailRequest) : AuthResponse

    @POST("/api/v1/oauth/token")
    suspend fun refreshToken(@Body request: RefreshTokenRequest) : AuthResponse

    @POST("/api/v1/passwords")
    suspend fun resetPassword(@Body request: ForgotPasswordRequest) : ForgotPasswordResponse

    @POST("/api/v1/oauth/revoke")
    suspend fun logout(@Body request: LogoutRequest) : LogoutResponse
}