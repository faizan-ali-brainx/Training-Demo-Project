package com.example.trainingdemoapp.utils

import com.google.gson.GsonBuilder
import java.lang.reflect.Modifier

fun Any.toJson(): String {
    val builder = GsonBuilder()
    builder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
    val gSon = builder.create()
    return gSon.toJson(this)
}