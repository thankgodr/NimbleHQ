package com.richard.nimble.feature_authentication.presentation.utils

import android.util.Patterns


object InputValidator {
    fun isValidEmail(target: String?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}