package com.example.listadetarefas2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val tarefaAdapter = TarefaAdapter()

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        toolbar.overflowIcon = getDrawable(R.drawable.ic_more_vert)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter=tarefaAdapter

        val tarefas=listOf(
            Tarefa("PROFISSIONAL","Programador Júnior","Estudar Kotlin"),
            Tarefa("SAÚDE FÍSICA E MENTAL","Equilíbrio psíquico","Estudar Kotlin"),
            Tarefa("EDUCAÇÃO","Licenciado em Música","Matricular"),
            Tarefa("FINANCEIRA","Reserva financeira","Arrumar novo trabalho")
        )

        tarefaAdapter.updateItems(tarefas)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.search -> {
            Toast.makeText(this, "Buscar item", Toast.LENGTH_LONG).show()
            true
        }
        R.id.incluir_Tarefa -> {
            val intent = Intent(this, Tela_inclusao_activity::class.java)
            startActivity(intent)
            true
        }
        R.id.func2 -> {
            Toast.makeText(this, "Funcionalidade 2", Toast.LENGTH_LONG).show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

}