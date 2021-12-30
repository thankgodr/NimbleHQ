package com.richard.nimble.feature_authentication.data.repository

import com.google.gson.Gson
import com.richard.nimble.feature_authentication.data.remote.NimpleAuthApi
import com.richard.nimble.feature_authentication.data.remote.dto.AuthResponse
import com.richard.nimble.feature_authentication.data.remote.dto.toCurrentUser
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.model.CurrentUser
import com.richard.nimble.feature_authentication.domain.repository.Authentication
import kotlinx.coroutines.delay
import javax.inject.Inject

class FakeAuthenticationImpl @Inject constructor(
    private val api : NimpleAuthApi
) : Authentication {
    val fakeRespons = "{\n" +
            "  \"data\": {\n" +
            "    \"id\": 10,\n" +
            "    \"type\": \"token\",\n" +
            "    \"attributes\": {\n" +
            "      \"access_token\": \"lbxD2K2BjbYtNzz8xjvh2FvSKx838KBCf79q773kq2c\",\n" +
            "      \"token_type\": \"Bearer\",\n" +
            "      \"expires_in\": 7200,\n" +
            "      \"refresh_token\": \"3zJz2oW0njxlj_I3ghyUBF7ZfdQKYXd2n0ODlMkAjHc\",\n" +
            "      \"created_at\": 1597169495\n" +
            "    }\n" +
            "  }\n" +
            "}"
    val gson = Gson()
    override suspend fun login(request: ClientAuthRequest): CurrentUser {
        delay(3000)
        return  gson.fromJson(fakeRespons,AuthResponse::class.java).toCurrentUser()
    }

    override suspend fun register(request: ClientAuthRequest): CurrentUser {
        return  gson.fromJson(fakeRespons,AuthResponse::class.java).toCurrentUser()
    }

    override suspend fun logout(request: ClientAuthRequest): String {
        return "Sucessfully logout"
    }

    override suspend fun resetPasword(request: ClientAuthRequest): String {
        return "Check your email"
    }

    override suspend fun refresh(request: ClientAuthRequest): CurrentUser {
       val faker = "{\n" +
               "  \"data\": {\n" +
               "    \"id\": 171,\n" +
               "    \"type\": \"token\",\n" +
               "    \"attributes\": {\n" +
               "      \"access_token\": \"6cmbWFycYr9GK5CZ5gRL0aFKZHkUADstNvty-jMqzrE\",\n" +
               "      \"token_type\": \"Bearer\",\n" +
               "      \"expires_in\": 7200,\n" +
               "      \"refresh_token\": \"oiL7neqlake97_PEbdYYGX_jKP_R8yv1JdojAQCzWus\",\n" +
               "      \"created_at\": 1600940029\n" +
               "    }\n" +
               "  }\n" +
               "}"
        return  gson.fromJson(faker,AuthResponse::class.java).toCurrentUser()

    }
}