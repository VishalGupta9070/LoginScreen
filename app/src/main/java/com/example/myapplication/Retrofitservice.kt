package com.example.myapplication

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*


interface Retrofitservice {
    @POST("LoginToApp")
    @Headers(
        "Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    suspend fun userLoginAsync(@Field (value = "login_name", encoded = true) login_name: String, @Field(value = "password", encoded = true) password: String ): Response<User>
}
