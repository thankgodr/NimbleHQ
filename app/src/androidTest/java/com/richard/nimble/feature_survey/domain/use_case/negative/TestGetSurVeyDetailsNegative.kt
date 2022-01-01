package com.richard.nimble.feature_survey.domain.use_case.negative

import com.google.common.truth.Truth
import com.richard.nimble.core.data.Resource
import com.richard.nimble.di.AppModule
import com.richard.nimble.di.TestAppModule
import com.richard.nimble.feature_survey.domain.GetSurveyDeatailsUseCase
import com.richard.nimble.feature_survey.domain.Survey
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
class TestGetSurVeyDetailsNegative {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var getSurveyDeatailsUseCase: GetSurveyDeatailsUseCase


    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun ShouldEmitLoadingFirst() = runBlockingTest {
        val emttions = getSurveyDeatailsUseCase("test")
        val first = emttions.first()
        Truth.assertThat(first).isInstanceOf(Resource.Loading::class.java)
    }

    @Test
    fun ShouldEmitError() = runBlockingTest {
        val emttions = getSurveyDeatailsUseCase("test")
        val last = emttions.last()
        Truth.assertThat(last).isInstanceOf(Resource.Error::class.java)
    }

    @Test
    fun ErrorShouldHaveAMessage() = runBlockingTest {
        val emttions = getSurveyDeatailsUseCase("test")
        val last = emttions.last()
        Truth.assertThat(last.message).isNotEmpty()
    }

}