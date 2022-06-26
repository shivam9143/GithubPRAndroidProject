package com.shivam.base.repository

import android.util.Log
import com.shivam.base.GenericSuccessFailResponse
import com.shivam.base.ResultWrapper
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException

open class BaseRepository {

    suspend fun <T> huddleSafeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        endpointName: String? = "",
        apiCall: suspend () -> T
    ): ResultWrapper<T> {
        return withContext(dispatcher) {
            try {
                ResultWrapper.Success(apiCall.invoke())
            } catch (throwable: Exception) {
                Log.e("RbBaseRepository", throwable.message.toString())
                when (throwable) {
                    is IOException -> ResultWrapper.NetworkError
                    is CancellationException -> {
                        ResultWrapper.CancellationError
                    }

                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse = convertErrorBody(throwable)
                        ResultWrapper.GenericError(code, errorResponse)
                    }

                    is SocketTimeoutException -> {
                        ResultWrapper.GenericError(
                            408,
                            GenericSuccessFailResponse(false, throwable.message.toString())
                        )
                    }
                    else -> {
                        ResultWrapper.GenericError(
                            null,
                            GenericSuccessFailResponse(false, throwable.message.toString())
                        )
                    }
                }
            }
        }
    }

    private fun convertErrorBody(throwable: HttpException): GenericSuccessFailResponse {
        return GenericSuccessFailResponse(
            false,
            throwable.response()?.errorBody()?.string()
        )
    }

}