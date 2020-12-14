package com.cuandoeramilitar.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Principal : AppCompatActivity() {

    var crud:ProductoCRUD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val id = findViewById<EditText>(R.id.Id)
        val Producto = findViewById<EditText>(R.id.idProducto)
        val Marca = findViewById<EditText>(R.id.idMarca)
        val Precio_compra = findViewById<EditText>(R.id.idPrecio_Compra)
        val Precio_venta = findViewById<EditText>(R.id.idPrecio_Venta)
        val bAdd = findViewById<Button>(R.id.idAgregar)

        crud = ProductoCRUD( this)

        bAdd.setOnClickListener{
            crud?.newProducto(Producto(id.text.toString(),Producto.text.toString(),Marca.text.toString(),Precio_compra.text.toString(),Precio_venta.text.toString()))
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}