package com.example.listadetarefas2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar

open class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIncluirTarefa: Button = findViewById(R.id.btnIncluirTarefa)

        val toolbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        btnIncluirTarefa.setOnClickListener {
            val intent = Intent(this, Tela_inclusao_activity::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem)=when(item.itemId) {
        R.id.search->{
            Toast.makeText(this,"Buscar item",Toast.LENGTH_LONG).show()
            true
        }
        R.id.func1->{
            Toast.makeText(this,"Funcionalidade1",Toast.LENGTH_LONG).show()
            true
        }
        R.id.func2->{
            Toast.makeText(this,"Funcionalidade 2",Toast.LENGTH_LONG).show()
            true
        }
        else->{
            super.onOptionsItemSelected(item)
        }
    }

}