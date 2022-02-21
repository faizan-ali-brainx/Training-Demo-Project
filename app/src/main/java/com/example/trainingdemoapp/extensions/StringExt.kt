package com.example.trainingdemoapp.extensions

import com.example.trainingdemoapp.utils.RegexUtils
import java.util.regex.Pattern

fun String?.isValidEmail(): Boolean? = this?.isValid(RegexUtils.EMAIL_REGEX)

fun String.isValid(regex: String?): Boolean {
    if (regex.isNullOrEmpty()) return false
    val matcher = Pattern.compile(regex).matcher(this)
    return matcher.matches()
}