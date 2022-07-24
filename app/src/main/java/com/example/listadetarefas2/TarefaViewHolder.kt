package com.example.listadetarefas2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaViewHolder(view:View):RecyclerView.ViewHolder(view){

    private val textViewvida=itemView.findViewById<TextView>(R.id.tv_area_vida)
    private val textViewobjetivo=itemView.findViewById<TextView>(R.id.tv_objetivo)
    private val textViewtarefa=itemView.findViewById<TextView>(R.id.tv_tarefa)

    fun bind(item:Tarefa){
        textViewvida.text=item.area_vida
        textViewobjetivo.text=item.objetivo
        textViewtarefa.text=item.tarefa

    }



}