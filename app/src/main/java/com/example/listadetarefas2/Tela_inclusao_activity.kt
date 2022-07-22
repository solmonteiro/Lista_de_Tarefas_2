package com.example.listadetarefas2

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyboardShortcutGroup
import android.widget.Button
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

class Tela_inclusao_activity : AppCompatActivity() {


    private lateinit var et_datainicial:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inclusao)

        et_datainicial=findViewById(R.id.et_datainicial)

        val myCalendar= Calendar.getInstance()
        val datePicker=DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR,year)
        myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLabel(myCalendar)

        }


       /** val actionBar =supportActionBar
        actionBar!!.title="Tela de Inclusão"
        actionBar.setDisplayHomeAsUpEnabled(true)*/

       val btn_cancelarinclusao: Button = findViewById(R.id.btn_cancelarinclusao)

        btn_cancelarinclusao.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        et_datainicial.setOnClickListener {

            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()


        }

    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat="dd-MM-yyyy"
        val sdf=SimpleDateFormat(myFormat,Locale.UK)
        et_datainicial.setText(sdf.format(myCalendar.time))

    }


}