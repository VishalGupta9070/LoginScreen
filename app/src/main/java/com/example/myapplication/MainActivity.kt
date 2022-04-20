package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    fun initViews(){
        val retrofitAPI = RetrofitClient()
binding.button.setOnClickListener {
userLogin(binding.editTextTextPersonName.text.toString(), binding.editTextTextPassword.text.toString())
}
    }
    private fun userLogin(login: String, password : String){
        CoroutineScope(Dispatchers.Default).launch {
            val retrofitAPI = RetrofitClient()
        val response = retrofitAPI.getRetrofitObj()?.create(Retrofitservice::class.java)?.userLoginAsync(login,password)?.await()
            if (response?.isSuccessful == true){
                val user = response.body()
        }
    }
}

}