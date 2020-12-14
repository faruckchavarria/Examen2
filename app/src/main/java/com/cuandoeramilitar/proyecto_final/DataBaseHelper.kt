package com.cuandoeramilitar.proyecto_final

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper (context: Context): SQLiteOpenHelper(context, ProductoContract.Companion.Entrada.NOMBRE_TABLA,null,ProductoContract.Companion.VERSION ) {
    companion object
    {
        val CREATE_PRODUCTO_TABLA= "CREATE_TABLE" + ProductoContract.Companion.Entrada.NOMBRE_TABLA +
                "(" + ProductoContract.Companion.Entrada.COLUMNA_ID + "TEXT PRIMARY KEY," +
                ProductoContract.Companion.Entrada.COLUMNA_PRODUCTO +"TEXT"+
                ProductoContract.Companion.Entrada.COLUMNA_MARCA +"TEXT"+
                ProductoContract.Companion.Entrada.COLUMNA_PRECIO_COMPRA + "TEXT"+
                ProductoContract.Companion.Entrada.COLUMNA_PRECIO_VENTA + "TEXT)"

        val REMOVE_PRODUCTO_TABLA = "DROP TABLE IF EXISTS" + ProductoContract.Companion.Entrada.NOMBRE_TABLA
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_PRODUCTO_TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, i: Int, i2: Int) {
    db?.execSQL(REMOVE_PRODUCTO_TABLA)
        onCreate(db)

    }

}