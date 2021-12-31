package com.richard.nimble.feature_authentication.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.richard.nimble.di.AppModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@UninstallModules(AppModule::class)
@HiltAndroidTest
class TestSessionManager {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var sessionManager: SessionManager

    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun SessionManagerSaveAuthToken(){
        val token = "validatorBlablah"
        sessionManager.saveAuthToken(token)
        assertThat(sessionManager.fetchAuthToken()).isEqualTo(token)
    }

    @Test
    fun sessionManagerSaverefreshToken(){
        val token = "validatorBlablahfgdhd"
        sessionManager.saveRefreshAuthToken(token)
        assertThat(sessionManager.fetchRefreshAuthToken()).isEqualTo(token)
    }
}