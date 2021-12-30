package com.richard.nimble.feature_authentication.presentation.utils

import android.text.TextUtils
import android.util.Patterns


object InputValidator {
    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}