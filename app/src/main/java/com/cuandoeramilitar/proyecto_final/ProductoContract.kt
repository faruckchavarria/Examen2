package com.cuandoeramilitar.proyecto_final

import android.provider.BaseColumns

class ProductoContract {

    companion object
    {
        class Entrada: BaseColumns
        {
            companion object
            {    //Nombre de la tabla
                val NOMBRE_TABLA = "Productos"
                //Nombre de las columnas de la tabla
                val COLUMNA_ID ="id"
                val COLUMNA_PRODUCTO ="Producto"
                val COLUMNA_MARCA ="Marca"
                val COLUMNA_PRECIO_COMPRA ="Precio_compra"
                val COLUMNA_PRECIO_VENTA ="Precio_venta"

            }
        }
    }
}