package com.example.trainingdemoapp.network

import com.example.trainingdemoapp.enums.Error
import com.example.trainingdemoapp.utils.Constants.EMPTY_STRING
import com.example.trainingdemoapp.utils.Constants.ZERO

class AppException : Exception {

    var errorMsg: String
    var errCode: Int = ZERO
    var errorLog: String?

    constructor(errCode: Int, error: String?, errorLog: String? = EMPTY_STRING) : super(error) {
        this.errorMsg = error ?: EMPTY_STRING
        this.errCode = errCode
        this.errorLog = errorLog?:this.errorMsg
    }

    constructor(error: Error, e: Throwable?) {
        errCode = error.getKey()
        errorMsg = error.getValue()
        errorLog = e?.message
    }
}