package com.example.listadetarefas2.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TarefasDatabase(
    context:Context
):SQLiteOpenHelper(context,"tarefas.db",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql ="""
        CREATE TABLE TB_CONTATOS(
        ID INTEGER PRIMARY KEY AUTOIMCREMENT,
        AREA TEXT,
        OBJETIVO TEXT,
        TAREFA TEXT
        );
        """.trimIndent()

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS TB_TAREFAS")
        onCreate(db)
    }


}