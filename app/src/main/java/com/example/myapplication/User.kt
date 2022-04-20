package com.example.myapplication

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User: Serializable{
    @SerializedName("user_id") var userId: String?= null
    @SerializedName("emp_id") var empId: String?= null
    @SerializedName("emp_name") var empName: String?=null
    @SerializedName("login_name") var loginName: String?=null
    @SerializedName("password") var password: String?=null
    @SerializedName("user_type") var userType: String?=null
    @SerializedName("email_id") var emailId: String?=null
    @SerializedName("auth_token") var authToken: String?=null
}
