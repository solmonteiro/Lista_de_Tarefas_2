package com.example.listadetarefas2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TarefaAdapter: RecyclerView.Adapter<TarefaViewHolder>() {

    private var items= listOf <Tarefa>()

    fun updateItems(newItems:List<Tarefa>){
        items=newItems
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view=LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_recycler,parent,false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int =items.size

}