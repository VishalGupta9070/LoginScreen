package com.example.myapplication

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*


interface Retrofitservice {
    @POST("LoginToApp")
    @Headers(
        "Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    suspend fun userLoginAsync(@Field("login_name") login_name: String, @Field("password") password: String ): Deferred<Response<User>>
}
