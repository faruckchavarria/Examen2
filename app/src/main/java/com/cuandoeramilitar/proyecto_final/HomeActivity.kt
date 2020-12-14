package com.cuandoeramilitar.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
    fun  LanzarRegistrar(view: View) {
        val intent = Intent(this,Principal ::class.java)
        startActivity(intent)
    }
}