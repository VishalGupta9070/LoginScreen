package com.example.myapplication

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    var retrofit : Retrofit?= null
    fun getRetrofitObj(): Retrofit? {
        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .header("Accept", "*/*")
                .header(
                    "X-Auth-Header",
                    "054e86b8f38982b32044973976716e1a942dd77fd0ddb3ca9c9421fb69146784"
                )
                .header("Authorization", "Bearer")

                .build()

            chain.proceed(request)}
            val httpClient: OkHttpClient.Builder =
                OkHttpClient.Builder().addInterceptor(interceptor)
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logInterceptor)
            if (retrofit != null) {
            return retrofit as Retrofit
        } else {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .baseUrl("https://rcst.in:8443/WD_API/Login/")
                .client(httpClient.build())
                .build()
        }
        return retrofit as Retrofit
    }
}