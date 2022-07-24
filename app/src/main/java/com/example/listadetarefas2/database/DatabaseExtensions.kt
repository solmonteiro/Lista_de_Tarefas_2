package com.example.listadetarefas2.database

import android.content.ContentValues
import com.example.listadetarefas2.Tarefa

fun TarefasDatabase.salvarTarefa(item:Tarefa):Long{

   val idTarefa = writableDatabase.insert("TB_TAREFAS",null, ContentValues().apply {
        put("AREA",item.area_vida)
        put("OBJETIVO",item.objetivo)
        put("TAREFA",item.tarefa)
    })

    return idTarefa
}