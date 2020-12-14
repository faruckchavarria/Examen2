package com.cuandoeramilitar.proyecto_final

class Producto(id:String, producto:String, Marca:String, Precio_compra: String, Precio_venta: String ) {
     var id:String? = null
     var Producto:String? = null
     var Marca:String? = null
     var Precio_compra:String? = null
     var Precio_venta:String? = null

    init {

        this.id=id;
        this.Producto=producto;
        this.Marca=Marca;
        this.Precio_compra=Precio_compra;
        this.Precio_venta=Precio_venta;
    }

}