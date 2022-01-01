package com.richard.nimble.feature_authentication.domain.use_case.negative

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import com.richard.nimble.core.data.Resource
import com.richard.nimble.di.AppModule
import com.richard.nimble.di.TestAppModule
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.use_case.LoginRegisterUseCase
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
class TestLoginRegisterUseCaseNegative {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var loginRegisterUseCase: LoginRegisterUseCase

    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun LoadingWasFirstEmitted() = runBlockingTest {
        val emittions = loginRegisterUseCase(ClientAuthRequest("",""))
        val firstItem = emittions.first()
        assertThat(firstItem).isInstanceOf(Resource.Loading::class.java)
    }

    @Test
    fun ValidErrorWasEmited() = runBlockingTest {
        val emittions = loginRegisterUseCase(ClientAuthRequest("",""))
        val last = emittions.last()
        assertThat(last).isInstanceOf(Resource.Error::class.java)
    }

    @Test
    fun ErrorHasAMessage() = runBlockingTest {
        val emittions = loginRegisterUseCase(ClientAuthRequest("",""))
        val last = emittions.last()
        assertThat(last.message).isNotEmpty()
    }

}