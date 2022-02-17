package com.example.trainingdemoapp.utils

object ApiUrls {
    private const val VERSION = "v1/"
    private const val API = "api/"
    private const val USERS = "users/"
    private const val USER = "user/"
    private const val QUOTES = "quotes/"
    private const val CB_LEVELUP = "https://www.cblevelup.com/"
    private const val USERS_API_SUB_ROOT = "${API}${VERSION}${USERS}"
    private const val USER_API_SUB_ROOT = "${API}${VERSION}${USER}"
    const val SIGN_IN = "/${USERS_API_SUB_ROOT}sign_in.json"
    const val TIPS = "/${API}${VERSION}tips"
}