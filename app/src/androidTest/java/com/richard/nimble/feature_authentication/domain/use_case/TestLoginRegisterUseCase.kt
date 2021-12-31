package com.richard.nimble.feature_authentication.domain.use_case

import com.richard.nimble.core.data.Resource
import com.richard.nimble.di.AppModule
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.model.CurrentUser
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.last


@UninstallModules(AppModule::class)
@HiltAndroidTest
class TestLoginRegisterUseCase {
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
    fun ValidUserWasReceived() = runBlockingTest {
        val emittions = loginRegisterUseCase(ClientAuthRequest("",""))
        val last = emittions.last()
        assertThat(last.data).isNotNull()
    }

    @Test
    fun AllUserTokensWasPresents() = runBlockingTest {
        val emittions = loginRegisterUseCase(ClientAuthRequest("",""))
        val last = emittions.last()
        assertThat(last.data!!.acessToken).isNotEmpty()
            .also {
                assertThat(last.data!!.refreshToken).isNotEmpty()
            }
    }
}