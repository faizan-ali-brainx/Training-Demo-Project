package com.example.trainingdemoapp.network

import android.net.ParseException
import com.example.trainingdemoapp.enums.Error.PARSE_ERROR
import com.example.trainingdemoapp.enums.Error.NETWORK_ERROR
import com.example.trainingdemoapp.enums.Error.SSL_ERROR
import com.example.trainingdemoapp.enums.Error.TIMEOUT_ERROR
import com.example.trainingdemoapp.enums.Error.UNKNOWN
import com.example.trainingdemoapp.utils.Constants.MSG
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.net.ConnectException

object ExceptionHandle {
    const val error_name = MSG

    fun handleException(e: Throwable?): AppException {
        val ex: AppException
        e?.let {
            when (it) {
                is HttpException -> {
                    return convertErrorBody(it)
                }
                is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> {
                    ex = AppException(
                        PARSE_ERROR,
                        e
                    )

                    return ex
                }
                is ConnectException -> {
                    ex = AppException(
                        NETWORK_ERROR,
                        e
                    )
                    return ex
                }
                is javax.net.ssl.SSLException -> {
                    ex = AppException(
                        SSL_ERROR,
                        e
                    )
                    return ex
                }
                is ConnectTimeoutException -> {
                    ex = AppException(
                        TIMEOUT_ERROR,
                        e
                    )
                    return ex
                }
                is java.net.SocketTimeoutException -> {
                    ex = AppException(
                        TIMEOUT_ERROR,
                        e
                    )
                    return ex
                }
                is java.net.UnknownHostException -> {
                    ex = AppException(
                        TIMEOUT_ERROR,
                        e
                    )
                    return ex
                }
                is AppException -> return it

                else -> {
                    ex = AppException(
                        UNKNOWN,
                        e
                    )
                    return ex
                }
            }
        }
        ex = AppException(UNKNOWN, e)

        return ex
    }


    private fun convertErrorBody(throwable: HttpException): AppException {

        var jobError = throwable.response()?.errorBody()?.string()
        return try {
            val obj = JSONObject(jobError)
            AppException(
                throwable.code(),
                obj.getString(error_name), obj.getString(error_name)
            )


        } catch (exception: Exception) {
            jobError = throwable.message().toString()
            AppException(
                throwable.code(),
                jobError, jobError
            )
        }
    }

}