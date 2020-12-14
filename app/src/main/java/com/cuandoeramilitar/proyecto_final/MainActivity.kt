package com.cuandoeramilitar.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var lista: RecyclerView? = null
    var adaptador: AdaptadorCustom? =null
    var layoutManager: RecyclerView.LayoutManager? = null
    var Producto: ArrayList<Producto>? = null
    var crud:ProductoCRUD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        lista = findViewById(R.id.lista)


        lista?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager

        fab.setOnClickListener{
            startActivity(Intent(this, Principal::class.java))
        }

        crud = ProductoCRUD(this)

        adaptador = AdaptadorCustom( Producto !!, object :ClickListener{
            override fun onClick(vista: View, index: Int){
                //click
            }
        }, object: LongClickListener{
            override fun longClick(vista: View, index: Int){}
        })

        lista?.adapter = adaptador
    }


}