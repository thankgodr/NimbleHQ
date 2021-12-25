package com.richard.nimble.core

import com.richard.nimble.BuildConfig


object Constants {
    object grantType{
       val  password = "password"
        val refresh = "refresh_token"
    }
    val apiKey = BuildConfig.CONSUMER_KEY
    val apiSecret = BuildConfig.CONSUMER_SECRET
}