package com.example.myapplication

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query


interface Retrofitservice {
    @Headers(
        "Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("Login/LoginToApp")
    suspend fun userLogin(@Query("login_name") login_name: String, @Query("password") password: String ): Deferred<Response<User>>
}
