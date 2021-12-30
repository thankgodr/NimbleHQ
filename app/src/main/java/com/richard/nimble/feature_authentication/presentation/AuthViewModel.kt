package com.richard.nimble.feature_authentication.presentation

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.*
import com.richard.nimble.core.data.Resource
import com.richard.nimble.feature_authentication.data.remote.dto.RefreshTokenRequest
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.use_case.LoginRegisterUseCase
import com.richard.nimble.feature_authentication.domain.use_case.RefreshTokenUseCase
import com.richard.nimble.feature_authentication.domain.use_case.SessionManager
import com.richard.nimble.feature_authentication.domain.wokers.RefreshTokenWorker
import com.richard.nimble.feature_authentication.presentation.utils.InputValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginRegisterUseCase: LoginRegisterUseCase,
    private val refreshTokenUseCase: RefreshTokenUseCase,
    private val sessionManager: SessionManager,
    @ApplicationContext private val context : Context
) : ViewModel() {

    //User inputs
    private val _emailInput = mutableStateOf("dev@nimblehq.co")
    private val _passwordInput = mutableStateOf("12345678")

    //Validators
    private val _invalideEmail = mutableStateOf(false)
    val invalideEmail : State<Boolean> = _invalideEmail
    private val _invalidPassword = mutableStateOf(false)
    val invalidPassword = _invalidPassword

    val emailInput :State<String> = _emailInput
    val passwordInput :State<String> = _passwordInput

    //User alreday exist in device
    private val _userLoggedIn = mutableStateOf(false)
    val userLoggedIn : State<Boolean> = _userLoggedIn

    fun setEmail(email: String){
        _emailInput.value = email
    }
    fun setPassword(password: String){
        _passwordInput.value = password
    }

    //Workmanager work ID
    var workID = ""

    //Authentication Logic
    private val  _authState = mutableStateOf(AuthState())
    val state : State<AuthState> = _authState
    private val _proceed = mutableStateOf(false)
    val proceed : State<Boolean> = _proceed

    private fun login(){
        loginRegisterUseCase(
            ClientAuthRequest(
                email = _emailInput.value,
                password = _passwordInput.value)).onEach { result ->

              when(result){
                  is Resource.Success -> {
                      Log.i("okh", result.data?.email?: "Error")
                      result.data?.let {
                          sessionManager.saveAuthToken(it.acessToken)
                          sessionManager.saveRefreshAuthToken(it.refreshToken)
                          _authState.value =  AuthState(userDetails = it, proceed = true)
                          _proceed.value = true
                          startRefreshWorkManager()
                      }
                  }
                  is Resource.Error -> {
                      Log.i("okh", result.message?: "Error")
                      _authState.value = AuthState(
                          error = result.message ?: "An unexpected error occured"
                      )
                  }
                  is Resource.Loading -> {
                      Log.i("okh", "loading")
                      _authState.value = AuthState(isLoading = true)
                  }
              }

        }.launchIn(viewModelScope)
    }

    fun validate() {
        var ready = true
        if(!InputValidator.isValidEmail(_emailInput.value)){
            _invalideEmail.value = true
            ready = false
        }
        if(_passwordInput.value.isBlank() || _passwordInput.value.isEmpty()){
            _invalidPassword.value = true
            ready = false
        }
        if(ready){
            login()
        }
    }

    private fun startRefreshWorkManager(){
        val constraint = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val refreshTokenRequest = PeriodicWorkRequestBuilder<RefreshTokenWorker>(
            20, TimeUnit.SECONDS,
        )
            .setConstraints(constraint)
            .build()
        WorkManager.getInstance(context).enqueue(refreshTokenRequest)
    }

    fun checkIfUserLoggedIn(){
        if(sessionManager.fetchAuthToken().isNullOrEmpty()){
            _userLoggedIn.value = false
        }else{
            _userLoggedIn.value = true
        }
    }



}