package com.richard.nimble.feature_survey.domain

import com.richard.nimble.core.data.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetSurveListUseCase @Inject constructor(
    private val surveys: SurveysSignature
) {

    operator fun invoke() : Flow<Resource<List<Survey>>> = flow{
        try {
            emit(Resource.Loading<List<Survey>>())
            val list = surveys.getSurveys()
            emit(Resource.Success<List<Survey>>(list))
        }catch (e : HttpException){
            emit(Resource.Error<List<Survey>>(e.localizedMessage ?: "Unknown Error" ))
        }catch (e : IOException){
            emit(Resource.Error<List<Survey>>("Couldn't reach server. Check your internet connection."))
        }
    }
}