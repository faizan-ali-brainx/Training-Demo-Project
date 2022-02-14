package com.example.trainingdemoapp.helpers

import com.example.trainingdemoapp.network.AppException
import com.example.trainingdemoapp.network.ExceptionHandle
import com.example.trainingdemoapp.network.ResultState
import okhttp3.Headers
import org.json.JSONObject
import retrofit2.Response

suspend fun <T> request(
    block: suspend () -> Response<T>,
    resultState: (ResultState<T>, Headers?) -> Unit,
) {
    runCatching {
        block()
    }.onSuccess {
        resultState(it.paresResult(it), it.headers())
    }.onFailure {
        resultState(paresException(it), null)
    }
}

fun <T> Response<T>.paresResult(result: Response<T>): ResultState<T> {
    return if (result.isSuccessful && result.body() != null) {
        ResultState.onAppSuccess(result.body())
    } else {
        ResultState.onAppError(getErrorBody(result))
    }
}

fun <T> paresException(e: Throwable): ResultState<T> {
    return ResultState.onAppError(ExceptionHandle.handleException(e))
}

fun <T> getErrorBody(result: Response<T>): AppException {

    if (result.errorBody() != null) {
        return try {
            val obj = JSONObject(result.errorBody()!!.string())
            AppException(
                result.code(),
                obj.getString(ExceptionHandle.error_name), obj.getString(ExceptionHandle.error_name)
            )

        } catch (exception: Exception) {
            AppException(
                result.code(),
                result.message(), result.message()
            )
        }
    } else {
        return AppException(
            result.code(),
            result.message(), result.message()
        )
    }
}