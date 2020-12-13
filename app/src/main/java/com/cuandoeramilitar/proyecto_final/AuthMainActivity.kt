package com.cuandoeramilitar.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class AuthMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
<<<<<<< HEAD:app/src/main/java/com/cuandoeramilitar/proyecto_final/AuthMainActivity.kt
        setContentView(R.layout.activity_auth)
        // Obtain the FirebaseAnalytics instance.
        //val analytics : FirebaseAnalytics = Firebase.analytics
        //val bundle = bundle()
        //bundle.putString("message","Integracion a Firebase completa)
        //analytics.logEvent("InitScreen",bundle)
=======
        setContentView(R.layout.activity_main)
>>>>>>> a29d09e75ac61d67f1ec0ddc285c552a648c7445:app/src/main/java/com/cuandoeramilitar/proyecto_final/MainActivity.kt

    }
}