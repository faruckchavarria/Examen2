package com.cuandoeramilitar.proyecto_final

class Producto(id:String, producto:String, Marca:String, Precio_compra: String, Precio_venta: String ) {
    private var id:String? = null
    private var Producto:String? = null
    private var Marca:String? = null
    private var Precio_compra:String? = null
    private var Precio_venta:String? = null

    init {

        this.id=id;
        this.Producto=producto;
        this.Marca=Marca;
        this.Precio_compra=Precio_compra;
        this.Precio_venta=Precio_venta;
    }

}