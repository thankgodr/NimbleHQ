package com.richard.nimble

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.richard.nimble.feature_authentication.domain.wokers.RefreshTokenWorkerFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class Nimble : Application(), Configuration.Provider{
    @Inject
    lateinit var workerFactory: RefreshTokenWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

}