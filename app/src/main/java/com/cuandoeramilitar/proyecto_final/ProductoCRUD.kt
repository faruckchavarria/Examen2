package com.cuandoeramilitar.proyecto_final

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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
    fun getProducto(): ArrayList<Producto>
    {
        val items:ArrayList<Producto> = ArrayList()
        //Abrir BD en modo lectura
        val db: SQLiteDatabase = helper?.readableDatabase!!
        //especificar columnas que quiero consultar
        val columnas = arrayOf(ProductoContract.Companion.Entrada.COLUMNA_ID, ProductoContract.Companion.Entrada.COLUMNA_PRODUCTO,ProductoContract.Companion.Entrada.COLUMNA_MARCA,ProductoContract.Companion.Entrada.COLUMNA_PRECIO_COMPRA,ProductoContract.Companion.Entrada.COLUMNA_PRECIO_VENTA )

        //Crear un cursor para recorrer la tabla
        val c:Cursor =db.query(
            ProductoContract.Companion.Entrada.NOMBRE_TABLA,
            columnas,
            null,
            null,
            null,
            null,
            null
        )
        //hacer recorrido de cursor de la tabla
        while (c.moveToNext()){
            items.add(Producto(
                c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_ID)),
                c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_PRODUCTO)),
                c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_MARCA)),
                c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_PRECIO_COMPRA)),
                c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_PRECIO_VENTA))
            ))
            }
// CERRAR DB
        db.close()
        return items
    }
    fun getProductos(id:String):Producto
    {
        var item:Producto? = null
        val db:SQLiteDatabase = helper?.readableDatabase!!

        var columnas = arrayOf(ProductoContract.Companion.Entrada.COLUMNA_ID,
                                ProductoContract.Companion.Entrada.COLUMNA_PRODUCTO,
                                ProductoContract.Companion.Entrada.COLUMNA_MARCA,
                                ProductoContract.Companion.Entrada.COLUMNA_PRECIO_COMPRA,
                                ProductoContract.Companion.Entrada.COLUMNA_PRECIO_VENTA)

        val c:Cursor = db.query(
            ProductoContract.Companion.Entrada.NOMBRE_TABLA,
            columnas,
            "id = ?",
            arrayOf(id),
            null,
            null,
            null

        )
        while (c.moveToNext()){
            item = Producto(c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_ID)),
            c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_PRODUCTO)),
            c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_MARCA)),
            c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_PRECIO_COMPRA)),
            c.getString(c.getColumnIndexOrThrow(ProductoContract.Companion.Entrada.COLUMNA_PRECIO_VENTA)))

        }
        c.close()

        return item!!
    }
    fun updateProducto(item:Producto)
    {
        val db:SQLiteDatabase = helper?.writableDatabase!!

        val values = ContentValues()
        values.put(ProductoContract.Companion.Entrada.COLUMNA_ID, item.id)
        values.put(ProductoContract.Companion.Entrada.COLUMNA_PRODUCTO, item.Producto)
        values.put(ProductoContract.Companion.Entrada.COLUMNA_MARCA, item.Marca)
        values.put(ProductoContract.Companion.Entrada.COLUMNA_PRECIO_COMPRA, item.Precio_compra)
        values.put(ProductoContract.Companion.Entrada.COLUMNA_PRECIO_VENTA, item.Precio_venta)

        db.update(
            ProductoContract.Companion.Entrada.NOMBRE_TABLA,
            values,
            "id =?",
            arrayOf(item.id))

        db.close()

    }

    fun deleteProducto(item:Producto)

    {
        val db:SQLiteDatabase = helper?.writableDatabase!!
        db.delete(ProductoContract.Companion.Entrada.NOMBRE_TABLA,
        "id =?",
        arrayOf(item.id))

        db.close()
    }
}