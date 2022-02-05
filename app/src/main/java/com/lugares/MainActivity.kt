package com.lugares

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lugares.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("YUHOO", "STARRRTT")
    }

    fun hacerLogin(v: View?) {
        Log.d("YUHOO", "CLICKKK")
    }
}