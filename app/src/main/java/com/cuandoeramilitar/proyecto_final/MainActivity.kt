package com.cuandoeramilitar.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Obtain the FirebaseAnalytics instance.
        //val analytics : FirebaseAnalytics = Firebase.analytics
        //val bundle = bundle()
        //bundle.putString("message","Integracion a Firebase completa)
        //analytics.logEvent("InitScreen",bundle)

        //val analytics : FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        //val bundle = bundle()
        //val bundle = bundle()
        //bundle.putString("message","Integracion a Firebase completa")
        //analytics.logEvent("InitScreen",bundle)
    }
}