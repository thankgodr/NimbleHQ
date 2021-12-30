package com.richard.nimble.core.data

import com.richard.nimble.BuildConfig


object Constants {
    object grantType{
       val  password = "password"
        val refresh = "refresh_token"
    }

    object Route {
        val login = "login"
        val resetPassword = "resetpassword"
        val loading = "loading"
        val splash = "splash"
    }

    val BASE_URL = "https://survey-api.nimblehq.co/"
    val apiKey = BuildConfig.CONSUMER_KEY
    val apiSecret = BuildConfig.CONSUMER_SECRET
}