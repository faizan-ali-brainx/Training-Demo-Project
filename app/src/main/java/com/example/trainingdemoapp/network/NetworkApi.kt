package com.example.trainingdemoapp.network

import com.google.gson.GsonBuilder
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class NetworkApi {

    companion object {

        private lateinit var appBaseUrl: String

        var headerMap: HashMap<String, String> = hashMapOf()

        val INSTANCE: NetworkApi by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkApi()
        }

        fun setBaseUrl(baseUrl: String) {
            appBaseUrl = baseUrl
        }
    }


    fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val a = object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val builder = chain.request().newBuilder()
                headerMap.forEach {
                    builder.addHeader(it.key, it.value).build()
                }
                return chain.proceed(builder.build())
            }
        }
        builder.apply {
            addInterceptor(logging)
            addInterceptor(a)
            connectTimeout(120, TimeUnit.SECONDS)
            readTimeout(120, TimeUnit.SECONDS)
            writeTimeout(120, TimeUnit.SECONDS)
        }
        return builder
    }

    fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder {
        return builder.apply {
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
    }

    fun <T> getApi(serviceClass: Class<T>, ): T {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(appBaseUrl)
            .client(okHttpClient)
        return setRetrofitBuilder(retrofitBuilder).build().create(serviceClass)
    }

    private val okHttpClient: OkHttpClient
        get() {
            var builder = RetrofitUrlManager.getInstance().with(OkHttpClient.Builder())
            builder = setHttpClientBuilder(builder)
            return builder.build()
        }

}