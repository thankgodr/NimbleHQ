package com.richard.nimble.feature_authentication.domain.use_case.negative

import com.google.common.truth.Truth
import com.richard.nimble.core.data.Resource
import com.richard.nimble.di.AppModule
import com.richard.nimble.di.TestAppModule
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.use_case.RefreshTokenUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@UninstallModules(AppModule::class, TestAppModule::class)
@HiltAndroidTest
class TestRefreshTokenUseCaseNegative {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var refreshTokenUseCase: RefreshTokenUseCase


    @Before
    fun init(){
        hiltRule.inject()
    }



    @Test
    fun ValidErrorWasEmited() = runBlockingTest {
        val emittions = refreshTokenUseCase(ClientAuthRequest("",""))
        val last = emittions.last()
        Truth.assertThat(last).isInstanceOf(Resource.Error::class.java)
    }

    @Test
    fun ErrorHasAMessage() = runBlockingTest {
        val emittions = refreshTokenUseCase(ClientAuthRequest("",""))
        val last = emittions.last()
        Truth.assertThat(last.message).isNotEmpty()
    }

}