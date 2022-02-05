package com.lugares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lugares.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnLogin.setOnClickListener { hacerLogin() }
    }

    fun hacerLogin(){
        Log.d("YAHOO", "CLICKKK")
    }
}