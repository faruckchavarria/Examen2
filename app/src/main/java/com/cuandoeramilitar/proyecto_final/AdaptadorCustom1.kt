package com.cuandoeramilitar.proyecto_final;

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdaptadorCustom(items:ArrayList<Producto>, var listener:ClickListener, var longClickListener: LongClickListener): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {



    var items: ArrayList<Producto>?=null
    var multiSeleccion = false

    var itemsSeleccionados:ArrayList<Int>? = null
    var viewHolder:ViewHolder? = null

    init {
        this.items = items
        itemsSeleccionados = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.template_producto,parent,false)
        viewHolder = ViewHolder(vista, listener, longClickListener)

        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)

        holder.producto?.text = item?.Producto
        holder.id?.text = item?.id
        holder.Marca?.text = item?.Marca
        holder.Precio_compra?.text = item?.Precio_compra
        holder.Precio_venta?.text = item?.Precio_venta

        if(itemsSeleccionados?.contains(position)!!){
            holder.vista.setBackgroundColor(Color.LTGRAY)
        }else{
            holder.vista.setBackgroundColor(Color.WHITE)
        }
    }

    fun iniciarActionMode(){
        multiSeleccion = true
    }

    fun destruirActionMode(){
        multiSeleccion = false
        itemsSeleccionados?.clear()
        notifyDataSetChanged()
    }

    fun terminarActionMode(){
        // eliminar elementos seleccionados
        for(item in itemsSeleccionados!!){
            itemsSeleccionados?.remove(item)
        }
        multiSeleccion = false
        notifyDataSetChanged()
    }

    fun seleccionarItem(index:Int){
        if(multiSeleccion){
            if(itemsSeleccionados?.contains(index)!!){
                itemsSeleccionados?.remove(index)
            }else{
                itemsSeleccionados?.add(index)
            }

            notifyDataSetChanged()
        }
    }

    fun obtenerNumeroElementosSeleccionados():Int{
        return itemsSeleccionados?.count()!!
    }

    fun eliminarSeleccionados(){
        if(itemsSeleccionados?.count()!! > 0){
            var itemsEliminados = ArrayList<Producto>()

            for(index in itemsSeleccionados!!){
                itemsEliminados.add(items?.get(index)!!)
            }

            items?.removeAll(itemsEliminados)
            itemsSeleccionados?.clear()
        }
    }


    class ViewHolder(vista: View, listener: ClickListener, longClickListener: LongClickListener): RecyclerView.ViewHolder(vista), View.OnClickListener, View.OnLongClickListener{

        var vista = vista

        var nombre: TextView? = null
        var id: TextView?= null
        var producto: TextView?= null
        var Marca: TextView?= null
        var Precio_compra: TextView?= null
        var Precio_venta: TextView?= null
        var listener:ClickListener? = null
        var longListener:LongClickListener? = null

        init {

            producto = vista.findViewById(R.id.tvProducto)
            id = vista.findViewById(R.id.tvid)
            Marca = vista.findViewById(R.id.tvMarca)
            Precio_compra = vista.findViewById(R.id.tvPrecio_compra)
            Precio_venta = vista.findViewById(R.id.tvPrecio_Venta)



            this.listener = listener
            this.longListener = longClickListener

            vista.setOnClickListener(this)
            vista.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }

        override fun onLongClick(v: View?): Boolean {
            this.longListener?.longClick(v!!, adapterPosition)
            return true
        }



    }


}