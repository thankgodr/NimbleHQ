package com.richard.nimble.di

import com.richard.nimble.core.Constants
import com.richard.nimble.feature_authentication.data.remote.NimpleAuthApi
import com.richard.nimble.feature_authentication.data.repository.AuthenticationImpl
import com.richard.nimble.feature_authentication.domain.repository.Authentication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesAuthApi() : NimpleAuthApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NimpleAuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api : NimpleAuthApi) : Authentication{
        return AuthenticationImpl(api)
    }
}