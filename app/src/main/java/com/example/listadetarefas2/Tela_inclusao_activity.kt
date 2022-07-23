package com.example.listadetarefas2

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil
import java.text.SimpleDateFormat
import java.util.*

class Tela_inclusao_activity : MainActivity() {


    private lateinit var et_datainicial: EditText
    private lateinit var et_datafinal:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inclusao)

        et_datainicial = findViewById(R.id.et_datainicial)
        et_datafinal = findViewById(R.id.et_datafinal)

        val toolbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btn_cancelarinclusao: Button = findViewById(R.id.btn_cancelarinclusao)

        val myCalendar = Calendar.getInstance()
        val myCalendar2 = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }

        val datePicker2= DatePickerDialog.OnDateSetListener {view,year2,month2,dayOfMonth2 ->
            myCalendar2.set(Calendar.YEAR,year2)
            myCalendar2.set(Calendar.MONTH, month2)
            myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth2)
            updateLabel2(myCalendar2)
        }


        /** val actionBar =supportActionBar
        actionBar!!.title="Tela de Inclusão"
        actionBar.setDisplayHomeAsUpEnabled(true)*/


        btn_cancelarinclusao.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        et_datainicial.setOnClickListener {

            DatePickerDialog(
                this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()

        }

        et_datafinal.setOnClickListener {
            DatePickerDialog(
                this,datePicker2,myCalendar2.get(Calendar.YEAR),myCalendar2.get(Calendar.MONTH),
                myCalendar2.get(Calendar.DAY_OF_MONTH)).show()
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