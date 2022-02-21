package com.example.trainingdemoapp.extensions

import com.example.trainingdemoapp.utils.Constants.UTC_TIME_FORMAT
import com.example.trainingdemoapp.utils.RegexUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

fun String?.isValidEmail(): Boolean? = this?.isValid(RegexUtils.EMAIL_REGEX)

fun String.isValid(regex: String?): Boolean {
    if (regex.isNullOrEmpty()) return false
    val matcher = Pattern.compile(regex).matcher(this)
    return matcher.matches()
}

fun String.capFirstLetter(): String {
    if (isNullOrEmpty()) return ""
    return substring(0, 1).toUpperCase(Locale.ROOT) + substring(1)
}

fun String.getDateWithServerTimeStamp(): Date? {
    val dateFormat = SimpleDateFormat(
        UTC_TIME_FORMAT,
        Locale.getDefault()
    )
    try {
        val mydate = dateFormat.parse(this)
        mydate.time
        return dateFormat.parse(this)
    } catch (e: ParseException) {
        return null
    }
}