package com.example.listadetarefas2

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.listadetarefas2.database.TarefasDatabase
import com.example.listadetarefas2.database.salvarTarefa
import java.text.SimpleDateFormat
import java.util.*

class Tela_inclusao_activity : MainActivity() {


    private lateinit var et_areaVida: EditText
    private lateinit var et_objetivo: EditText
    private lateinit var et_tarefa: EditText
    private lateinit var btn_salvar: Button

    private lateinit var database: TarefasDatabase
    private var idtarefa: Int? = null


    private lateinit var et_datainicial: EditText
    private lateinit var et_datafinal: EditText

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inclusao)

        et_areaVida = findViewById(R.id.et_areaVida)
        et_objetivo = findViewById(R.id.et_objetivo)
        et_tarefa = findViewById(R.id.et_tarefa)
        btn_salvar = findViewById(R.id.btn_salvar)
        et_datainicial = findViewById(R.id.et_datainicial)
        et_datafinal = findViewById(R.id.et_datafinal)
        database = TarefasDatabase(this)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.overflowIcon = getDrawable(R.drawable.ic_more_vert) /*ícone branco*/

        val myCalendar = Calendar.getInstance()
        val myCalendar2 = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }

        val datePicker2 = DatePickerDialog.OnDateSetListener { view, year2, month2, dayOfMonth2 ->
            myCalendar2.set(Calendar.YEAR, year2)
            myCalendar2.set(Calendar.MONTH, month2)
            myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth2)
            updateLabel2(myCalendar2)
        }


        btn_salvar.setOnClickListener {
            salvarTarefa()
        }


        et_datainicial.setOnClickListener {

            DatePickerDialog(
                this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()

        }


        et_datafinal.setOnClickListener {
            DatePickerDialog(
                this, datePicker2, myCalendar2.get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
                myCalendar2.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        idtarefa = intent.getIntExtra("ID_TAREFA", -1)
/*acrescentar código para chamar dados*/

    }

    private fun salvarTarefa() {

        val tarefa = Tarefa(
            area_vida = et_areaVida.text.toString(),
            objetivo = et_objetivo.text.toString(),
            tarefa = et_objetivo.text.toString()
        )

        val idcontato = database.salvarTarefa(tarefa)

        if (idcontato == -1L) {
            Toast.makeText(this, "Erro ao inserir", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Contato inserido com sucesso id:$idcontato", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        et_datainicial.setText(sdf.format(myCalendar.time))

    }

    private fun updateLabel2(myCalendar2: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        et_datafinal.setText(sdf.format(myCalendar2.time))

    }


}