package com.richard.nimble.di

import com.richard.nimble.core.data.Constants
import com.richard.nimble.feature_authentication.data.remote.NimpleAuthApi
import com.richard.nimble.feature_authentication.data.repository.AuthenticationImpl
import com.richard.nimble.feature_authentication.data.repository.FakeAuthenticationImpl
import com.richard.nimble.feature_authentication.data.repository.FakeAuthenticationNegativeImple
import com.richard.nimble.feature_authentication.domain.repository.Authentication
import com.richard.nimble.feature_authentication.domain.use_case.LoginRegisterUseCase
import com.richard.nimble.feature_authentication.domain.use_case.SessionManager
import com.richard.nimble.feature_survey.data.remote.SurveyApi
import com.richard.nimble.feature_survey.data.repository.FakeSurveyImpl
import com.richard.nimble.feature_survey.data.repository.FakeSurveyNegativeImpl
import com.richard.nimble.feature_survey.data.repository.SurveysImpl
import com.richard.nimble.feature_survey.domain.SurveysSignature
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModuleNegative {

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
    fun provideAuthRepository(api : NimpleAuthApi) : Authentication {
        return FakeAuthenticationNegativeImple(api)
    }

    @Provides
    @Singleton
    fun provideSurveyRepo(api : SurveyApi) : SurveysSignature {
        return FakeSurveyNegativeImpl(api)
    }

    @Provides
    @Singleton
    fun provideSurveyAPi(sessionManager: SessionManager) : SurveyApi{
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(Interceptor { chain ->
            val request : Request = chain
                .request()
                .newBuilder()
                .addHeader("Authorization",
                    "Bearer ${sessionManager.fetchAuthToken() ?: ""}")
                .build()
            chain.proceed(request)
        })
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(SurveyApi::class.java)
    }


}


