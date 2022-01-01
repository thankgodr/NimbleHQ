package com.richard.nimble.feature_authentication.domain.use_case.negative

import com.google.common.truth.Truth
import com.richard.nimble.di.AppModule
import com.richard.nimble.di.TestAppModule
import com.richard.nimble.feature_authentication.domain.use_case.SessionManager
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@UninstallModules(AppModule::class, TestAppModule::class)
@HiltAndroidTest
class TestSessionManagerNegative {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var sessionManager: SessionManager

    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun tokenShoulNotBeEmptyAfterSave(){
        val token = "validatorBlablah"
        sessionManager.saveAuthToken(token)
        Truth.assertThat(sessionManager.fetchAuthToken()).isNotEmpty()
    }

    @Test
    fun refreshTokenShoulNotBeEmptyAfterSave(){
        val token = "validatorBlablahfgdhd"
        sessionManager.saveRefreshAuthToken(token)
        Truth.assertThat(sessionManager.fetchRefreshAuthToken()).isNotEmpty()
    }

}