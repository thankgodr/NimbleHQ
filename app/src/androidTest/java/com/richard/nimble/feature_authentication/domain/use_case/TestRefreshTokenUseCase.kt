package com.richard.nimble.feature_authentication.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.richard.nimble.core.data.Resource
import com.richard.nimble.di.AppModule
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
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

@UninstallModules(AppModule::class)
@HiltAndroidTest
class TestRefreshTokenUseCase {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var refreshTokenUseCase: RefreshTokenUseCase

    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun firEmetionsShouldBeSuscessOrError() = runBlockingTest {
        val emittions = refreshTokenUseCase(ClientAuthRequest("",""))
        val first = emittions.first()
        assertThat(first).isInstanceOf(Resource.Success::class.java)
    }

    @Test
    fun FlowEmttionsWasOfTyperesource() = runBlockingTest {
        val emittions = refreshTokenUseCase(ClientAuthRequest("",""))
        val first = emittions.last()
        assertThat(first).isInstanceOf(Resource::class.java)
    }







}