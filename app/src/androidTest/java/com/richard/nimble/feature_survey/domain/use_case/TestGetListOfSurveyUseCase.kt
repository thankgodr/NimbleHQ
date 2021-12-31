package com.richard.nimble.feature_survey.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.richard.nimble.core.data.Resource
import com.richard.nimble.di.AppModule
import com.richard.nimble.feature_survey.domain.GetSurveListUseCase
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

@UninstallModules(AppModule::class)
@HiltAndroidTest
class TestGetListOfSurveyUseCase {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var getListOfSurveyUseCase: GetSurveListUseCase

    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun ShouldEmitLoadingFirst() = runBlockingTest {
        val emttions = getListOfSurveyUseCase()
        val first = emttions.first()
        assertThat(first).isInstanceOf(Resource.Loading::class.java)
    }

    @Test
    fun ShouldEmitListOfSurvey() = runBlockingTest {
        val emttions = getListOfSurveyUseCase()
        val last = emttions.last()
        val survry = last.data?.get(0)
        assertThat(survry).isInstanceOf(Survey::class.java)
    }
}