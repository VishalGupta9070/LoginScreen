package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.databinding.ActivityMainBinding

private const val TAG = "HomeActivity"
class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getSerializableExtra("user") as User
        binding.userName.text = user.empName
        Log.e(TAG, "onCreate: ${user.empName}", )
        binding.userId.text = user.userId
        binding.empId.text = user.empId
        binding.emailId.text = user.emailId
        binding.userType.text = user.userType
    }
}