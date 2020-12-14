package com.cuandoeramilitar.proyecto_final

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ProductoCRUD(context: Context) {

    private var helper:DataBaseHelper? = null
    init {
    helper  = DataBaseHelper(context)
    }

    fun newProducto(item:Producto)
    {
        //abrir la DB en modo escritura
        val db: SQLiteDatabase = helper?.writableDatabase!!

        //mapeo de columnas con valores a insertar
        val values = ContentValues()
        values.put(ProductoContract.Companion.Entrada.COLUMNA_ID, item.id)
        values.put(ProductoContract.Companion.Entrada.COLUMNA_PRODUCTO, item.Producto)
        values.put(ProductoContract.Companion.Entrada.COLUMNA_MARCA, item.Marca)
        values.put(ProductoContract.Companion.Entrada.COLUMNA_PRECIO_COMPRA, item.Precio_compra)
        values.put(ProductoContract.Companion.Entrada.COLUMNA_PRECIO_VENTA, item.Precio_venta)

        // Insertar una nueva fila en la tabla
        val newRowId = db.insert(ProductoContract.Companion.Entrada.NOMBRE_TABLA, null, values)

        db.close()

    }
}