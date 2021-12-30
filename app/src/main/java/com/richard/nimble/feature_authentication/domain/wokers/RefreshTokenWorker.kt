package com.richard.nimble.feature_authentication.domain.wokers

import android.content.Context
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.richard.nimble.core.data.Resource
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.use_case.RefreshTokenUseCase
import com.richard.nimble.feature_authentication.domain.use_case.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import kotlin.coroutines.ContinuationInterceptor

class RefreshTokenWorker constructor(
    private val context: Context,
    private val params : WorkerParameters,
    private val refreshTokenUseCase: RefreshTokenUseCase,
    private val sessionManager: SessionManager
    ) : CoroutineWorker(
    context,params
) {


    override suspend fun doWork(): Result {
        var res : Result = Result.retry()
        refreshTokenUseCase(             ClientAuthRequest(
                    email = "",
                    password = "",
                    refreshToken = sessionManager.fetchRefreshAuthToken() ?: ""
                )
            )
            .onEach { result ->
                when(result){
                    is Resource.Success -> {
                        Log.d("okh", "e happen")
                        result.data?.let{
                            sessionManager.saveRefreshAuthToken(it.refreshToken)
                            sessionManager.saveAuthToken(it.acessToken)
                        }
                        res = Result.success()
                    }
                    is Resource.Error -> {
                        Log.d("okh", "e nothin oo")
                        res = Result.retry()
                    }
                }
            }.launchIn(CoroutineScope(coroutineContext))

        return res
    }
}