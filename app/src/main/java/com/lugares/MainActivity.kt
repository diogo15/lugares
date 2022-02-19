package com.lugares

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lugares.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btLogin.setOnClickListener { haceLogin() }
        binding.btRegister.setOnClickListener { haceRegister() }

    }

    private fun haceLogin(){
        val email = binding.etEmail.toString()
        val clave = binding.etClave.toString()

        auth.signInWithEmailAndPassword(email,clave)
        .addOnCompleteListener(this){ task ->
            if(task.isSuccessful){
                Log.d("Auth", "Usuario creado")
                val user = auth.currentUser
                actualiza(user)
            }
        }
    }
    private fun haceRegister(){
        val email = binding.etEmail.toString()
        val clave = binding.etClave.toString()

        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    Log.d("Auth", "Usuario creado")
                    val user = auth.currentUser
                    actualiza(user)
                }
            }
    }

    private fun actualiza(user: FirebaseUser? ){
        if (user != null){
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }

    }
}