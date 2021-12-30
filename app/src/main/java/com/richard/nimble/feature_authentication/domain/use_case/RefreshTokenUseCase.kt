package com.richard.nimble.feature_authentication.domain.use_case

import com.richard.nimble.core.data.Resource
import com.richard.nimble.feature_authentication.domain.model.ClientAuthRequest
import com.richard.nimble.feature_authentication.domain.model.CurrentUser
import com.richard.nimble.feature_authentication.domain.repository.Authentication
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(
    private val authEntication : Authentication
)  {
    operator fun invoke(request: ClientAuthRequest) : Flow<Resource<CurrentUser>> = flow{
        try{
            val userInfor = authEntication.refresh(request)
            emit(Resource.Success<CurrentUser>(userInfor))
        }catch (e : HttpException){
            emit(Resource.Error<CurrentUser>(e.localizedMessage ?: "Unknown Error" ))
        }catch (e : IOException){
            emit(Resource.Error<CurrentUser>("Couldn't reach server. Check your internet connection."))
        }
    }
}