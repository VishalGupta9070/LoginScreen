package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    fun initViews(){

binding.button.setOnClickListener {
userLogin(binding.editTextTextPersonName.text.toString(), binding.editTextTextPassword.text.toString())
}
    }
    private fun userLogin(login: String, password : String){
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val retrofitAPI = RetrofitClient()
                val response = retrofitAPI.getRetrofitObj()?.create(Retrofitservice::class.java)
                    ?.userLoginAsync(login, password)
                if (response?.isSuccessful == true) {
                    val user = response?.body()
                    val intent= Intent(this@MainActivity, HomeActivity::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                    Log.e(TAG, "userLogin: ${user?.empId}", )
                }
        }catch (e:Exception){
                Log.e(TAG, "userLogin: ${e.message}", )

        }
            }

}

}