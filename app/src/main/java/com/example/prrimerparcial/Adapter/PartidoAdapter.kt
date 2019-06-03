package com.example.prrimerparcial.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.example.prrimerparcial.PartidoDTO
import com.example.prrimerparcial.R
import com.example.prrimerparcial.database.Partido
import kotlinx.android.synthetic.main.item_list.view.*

class PartidoAdapter internal  constructor(context: Context): RecyclerView.Adapter<PartidoAdapter.PartidoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var partidos = emptyList<Partido>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.item_list,parent,false)
        return PartidoViewHolder(itemView)
    }

    override fun getItemCount() = partidos.size

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        val current = partidos[position]

        holder.bind(current)
    }

    fun setPartidos(partidos: List<Partido>){
        this.partidos = partidos
        notifyDataSetChanged()
    }


    inner class PartidoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(item: Partido) = with(itemView){
            local.text = item.equipoLocal
            puntostotal_local.text = item.puntosLocal
            visita.text = item.equipoVisitante
            puntostotal_visita.text = item.puntosVisitante
            fecha.text = item.fecha
            hora.text = item.hora
            //this.setOnClickListener{clickListener(item)}
        }
    }





}