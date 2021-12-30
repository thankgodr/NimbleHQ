package com.richard.nimble.feature_survey.domain

import com.richard.nimble.core.data.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetSurveyDeatailsUseCase @Inject constructor(
    private val surveysSignature: SurveysSignature
) {

    operator fun invoke(surveyId : String) : Flow<Resource<Survey>> = flow{
        try{
            emit(Resource.Loading<Survey>())
            val survey = surveysSignature.getSurveyDetails(surveyId)
            emit(Resource.Success<Survey>(survey))
        }catch (e : HttpException){
            emit(Resource.Error<Survey>(e.localizedMessage ?: "Unknown Error" ))
        }catch (e : IOException){
            emit(Resource.Error<Survey>("Couldn't reach server. Check your internet connection."))
        }
    }
}