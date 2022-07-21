package com.example.listadetarefas2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

val btnIncluirTarefa:Button =findViewById(R.id.btnIncluirTarefa)

btnIncluirTarefa.setOnClickListener {
    val intent=Intent(this,tela_inclusao_activity::class.java)
    startActivity(intent)
}

    }


}