package com.richard.nimble.feature_authentication.domain.use_case

import android.content.Context
import android.content.SharedPreferences
import com.richard.nimble.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionManager @Inject() constructor(
    @ApplicationContext val context: Context
) {
    private var prefs: SharedPreferences = context
        .getSharedPreferences(context.getString(R.string.app_name),
            Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_REFRESH_TOKEN = "user_refesh"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }


    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    /**
     * Function to save refresh token
     */
    fun saveRefreshAuthToken(token : String){
        val editor = prefs.edit()
        editor.putString(USER_REFRESH_TOKEN, token)
        editor.apply()
    }

    /**
     * Function to fetch refresh token
     */
    fun fetchRefreshAuthToken(): String? {
        return prefs.getString(USER_REFRESH_TOKEN, null)
    }
}