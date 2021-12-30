package com.richard.nimble.di

import android.content.Context
import com.richard.nimble.feature_authentication.domain.use_case.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    fun provideSessionManager(@ApplicationContext context: Context) : SessionManager{
        return SessionManager(context = context)
    }
}