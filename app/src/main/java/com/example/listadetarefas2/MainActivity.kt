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
import com.example.listadetarefas2.database.TarefasDatabase
import com.example.listadetarefas2.database.selecionarTarefas

open class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val tarefaAdapter = TarefaAdapter()

    private lateinit var database: TarefasDatabase

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
        recyclerView.adapter = tarefaAdapter

        database = TarefasDatabase(this)

        val tarefas = database.selecionarTarefas()

        tarefaAdapter.updateItems(tarefas)
    }


    override fun onResume() {
        super.onResume()

        val tarefas = database.selecionarTarefas().map {
            it.copy(onClick = ::abrirDetalhes)

        }
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


    private fun abrirDetalhes(idtarefa: Int?) {
        val intent = Intent(this, Tela_inclusao_activity::class.java)
        intent.putExtra("ID_TAREFA",idtarefa)

        startActivity(intent)

    }


}