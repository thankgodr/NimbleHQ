package com.richard.nimble.feature_authentication.domain.wokers

import androidx.work.ListenableWorker
import com.richard.nimble.core.data.Resource
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.use_case.RefreshTokenUseCase
import com.richard.nimble.feature_authentication.domain.use_case.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Refressher @Inject constructor(
    private val sessionManager: SessionManager,
    private val refreshTokenUsecase : RefreshTokenUseCase,
) {

    operator fun invoke() : Boolean{
        val refreshToken = sessionManager.fetchRefreshAuthToken()
        var res = false
        runBlocking {
            refreshTokenUsecase(
                ClientAuthRequest(
                    email = "",
                    password = "",
                    refreshToken = refreshToken ?: ""

                )).onEach{
                when(it){
                    is Resource.Success -> {
                        it.data?.let { currentUser ->
                            sessionManager.saveAuthToken(currentUser.acessToken)
                            sessionManager.saveRefreshAuthToken(currentUser.refreshToken)
                            res = true
                        }
                    }
                    is Resource.Error -> {
                        res = false
                    }
                }
            }
        }
        return res
    }
}