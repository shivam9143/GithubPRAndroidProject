package com.shivam.base

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class Failure<out T>(val value: T): ResultWrapper<T>()
    data class GenericError(val code: Int? = null, val error: GenericSuccessFailResponse? = null): ResultWrapper<Nothing>()
    object NetworkError: ResultWrapper<Nothing>()
    object HttpError: ResultWrapper<Nothing>(){}
    object CancellationError: ResultWrapper<Nothing>()
}

data class GenericSuccessFailResponse(val success: Boolean, val message: String? = null)

