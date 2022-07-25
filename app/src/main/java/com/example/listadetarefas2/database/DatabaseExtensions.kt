package com.example.listadetarefas2.database

import android.annotation.SuppressLint
import android.content.ContentValues
import com.example.listadetarefas2.Tarefa

fun TarefasDatabase.salvarTarefa(item: Tarefa): Long {

    val idTarefa = writableDatabase.insert("TB_TAREFAS", null, ContentValues().apply {
        put("AREA", item.area_vida)
        put("OBJETIVO", item.objetivo)
        put("TAREFA", item.tarefa)
    })

    return idTarefa
}

@SuppressLint("Range")
fun TarefasDatabase.selecionarTarefas(): List<Tarefa> {

    val sql = "SELECT * FROM TB_TAREFAS"

    val cursor = readableDatabase.rawQuery(sql, null)
    val tarefaList = mutableListOf<Tarefa>()

    if (cursor.count > 0) {
        while (cursor.moveToNext()) {

            val tarefa = Tarefa(
                id = cursor.getInt(cursor.getColumnIndex("ID")),
                area_vida = cursor.getString(cursor.getColumnIndex("AREA")),
                objetivo = cursor.getString(cursor.getColumnIndex("OBJETIVO")),
                tarefa = cursor.getString(cursor.getColumnIndex("TAREFA")),
            )
            tarefaList.add(tarefa)
        }

        cursor.close()

    }
    return tarefaList
}

fun TarefasDatabase.atualizarTarefas(item: Tarefa): Int {

    val valores = ContentValues().apply {
        put("AREA", item.area_vida)
        put("OBJETIVO", item.objetivo)
        put("TAREFA", item.tarefa)
    }

    return writableDatabase.update("TB_TAREFAS", valores, "ID=${item.id}", null)

}