package com.richard.nimble.feature_authentication.presentation

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.richard.nimble.core.data.Constants
import com.richard.nimble.di.AppModule
import com.richard.nimble.feature_authentication.presentation.components.NavigationHost
import com.richard.nimble.feature_authentication.presentation.screens.auth.LoginScreen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@UninstallModules(AppModule::class)
@HiltAndroidTest
class TestLoginUI {
    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun init(){
        hiltTestRule.inject()
        composeTestRule.setContent {
            val nav = rememberNavController()
            NavigationHost(navController = nav)
            nav.navigate(Constants.Route.login)
        }
    }

    @Test
    fun EMailFieldExists(){
        composeTestRule.onNodeWithText("dev@nimblehq.co").assertExists()
    }


}