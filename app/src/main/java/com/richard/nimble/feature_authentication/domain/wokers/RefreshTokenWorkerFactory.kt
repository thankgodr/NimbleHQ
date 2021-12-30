package com.richard.nimble.feature_authentication.domain.wokers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.richard.nimble.feature_authentication.domain.use_case.RefreshTokenUseCase
import com.richard.nimble.feature_authentication.domain.use_case.SessionManager
import javax.inject.Inject

class RefreshTokenWorkerFactory @Inject constructor (
    private val refreshTokenUseCase: RefreshTokenUseCase,
    private val sessionManager: SessionManager
): WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when(workerClassName){
            RefreshTokenWorker::class.java.name ->
                RefreshTokenWorker(appContext,workerParameters, refreshTokenUseCase, sessionManager )
            else -> null
        }
    }
}