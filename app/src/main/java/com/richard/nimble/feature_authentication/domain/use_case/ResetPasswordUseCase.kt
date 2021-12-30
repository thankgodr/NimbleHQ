package com.richard.nimble.feature_authentication.domain.use_case

import com.richard.nimble.core.data.Resource
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.repository.Authentication
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ResetPasswordUseCase @Inject constructor(
    private val api : Authentication
){
    operator fun invoke(request: ClientAuthRequest) : Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading<String>())
            val res = api.resetPasword(request)
            emit(Resource.Success<String>(res))
        } catch (e: HttpException) {
            emit(Resource.Error<String>(e.localizedMessage ?: "Unknown Error"))
        } catch (e: IOException) {
            emit(Resource.Error<String>("Couldn't reach server. Check your internet connection."))
        }
    }

}