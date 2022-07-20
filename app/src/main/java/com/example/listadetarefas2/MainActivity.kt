package com.example.listadetarefas2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: MutableList<String>=ArrayList()
        list.add("PROGRAMADOR ANDROID JÚNIOR")
        list.add("PROFESSOR UNIVERSITÁRIO")

val adapter:ArrayAdapter<String!> = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
     spnTest.adapter=adapter
    }


}